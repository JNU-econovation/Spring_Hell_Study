package org.example.springstudy.service.order;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.springstudy.domain.goods.Goods;
import org.example.springstudy.domain.order.Order;
import org.example.springstudy.domain.order.OrderGoods;
import org.example.springstudy.domain.order.OrderGoodsRepository;
import org.example.springstudy.domain.order.OrderRepository;
import org.example.springstudy.domain.user.*;
import org.example.springstudy.dto.order.request.CityHallUserOrderDTO;
import org.example.springstudy.dto.order.request.FestivalUserOrderDTO;
import org.example.springstudy.dto.order.request.OrderGoodsDTO;
import org.example.springstudy.exception.*;
import org.example.springstudy.service.discount.CityHallUserDiscountPolicy;
import org.example.springstudy.service.discount.FestivalUserDiscountPolicy;
import org.example.springstudy.service.goods.GoodsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderGoodsRepository orderGoodsRepository;
    private final GoodsService goodsService;
    private final UserRepository userRepository;
    // UserRepository로만 해결해보려고 했는데
    // Role로 User 찾기가 어려워서 결국 FestivalUserRepository를 만들었어요...
    private final FestivalUserRepository festivalUserRepository;

    // 할인정책을 어떻게 해야할지를 정말 모르겠어서 그냥 두 개 만들어놓았습니다 ㅠㅠ
    private final CityHallUserDiscountPolicy cityHallUserDiscountPolicy;
    private final FestivalUserDiscountPolicy festivalUserDiscountPolicy;
    // 시청이 인쇄소에 발주요청
    @Transactional
    public Long cityHallUserOrder(CityHallUserOrderDTO cityHallUserOrderDTO){
        CityHallUser cityHallUser = (CityHallUser) userRepository
                .findById(cityHallUserOrderDTO.getUserId())
                .orElseThrow(UserNotFoundException::new);

        int totalOrderPrice = 0;
        int totalOrderCount = 0;

        List<OrderGoods> orderGoodsList = new ArrayList<>();

        // stream 사용법에 미숙해서 코드가 좀 많이 더러워요...
        for (int i = 0; i< cityHallUserOrderDTO.getOrderGoodsDTOList().size(); i++){
            OrderGoodsDTO orderGoodsDTO = cityHallUserOrderDTO.getOrderGoodsDTOList().get(i);
            Goods goods = goodsService.findCategory(orderGoodsDTO.getCategoryName()).getGoods();

            // 100개 단위로 주문하지 않으면 에러
            int orderCount = orderGoodsDTO.getCount();
            totalOrderCount += orderCount;
            if((orderCount / 100) < 1){
                throw new CityHallUserOrderCountException();
            }else{
                goods.addStockQuantity(orderCount);
            }

            // 총 주문 가격 더하기
            int orderPrice = 10000 * (orderGoodsDTO.getCount()/100);
            totalOrderPrice += orderPrice;


            OrderGoods orderGoods = createOrderGoodsFromDTO(orderGoodsDTO, goods);
            orderGoodsRepository.save(orderGoods);
            orderGoodsList.add(orderGoods);
        }
        int discountPrice = cityHallUserDiscountPolicy.calculateDiscountPrice(totalOrderCount);
        totalOrderPrice -= discountPrice;

        // 주문 가격이 0원 이하일 시 에러
        if (totalOrderPrice < 0){
            throw new OrderPriceException();
        }

        // 잔액 부족 에러
        if (totalOrderPrice > cityHallUser.getBudget()){
            throw new NotEnoughMoneyException();
        }else{
            cityHallUser.Order(totalOrderPrice);
        }

        Order order = Order.builder()
                .user(cityHallUser)
                .orderGoodsList(orderGoodsList)
                .build();

        return orderRepository.save(order).getId();
    }
    // 축제 참가자 주문
    @Transactional
    public Long festivalUserOrder(FestivalUserOrderDTO festivalUserOrderDTO){
        FestivalUser festivalUser = (FestivalUser)userRepository
                .findById(festivalUserOrderDTO.getUserId())
                .orElseThrow(UserNotFoundException::new);

        // festivalUserEntity에 들어가는게 맞겠다.
        int CAN_BUY_MAX_GOODS = 8;

        // 모든 goods의 id값을 모아놓은 리스트
        List<Long> allGoodsIdList = new ArrayList<>();
        List<Goods> goodsList = goodsService.findAllGoods();
        for (Goods goods : goodsList) {
            // 재고가 0이상인 굿즈들만 추가
            // 굿즈중에서 재고가 0인 굿즈는 판매할 수 없음
            if (goods.getStockQuantity() > 0){
            allGoodsIdList.add(goods.getId());
            }
        }

        // goods를 지금까지 총 몇 개 샀는지, 뭐 샀는지
        List<Order> userOrders = festivalUser.getOrders();
        int countOrderedGoods = 0;
        for (Order usersOrder : userOrders) {
            List<OrderGoods> orderGoodsList = usersOrder.getOrderGoodsList();
            for (OrderGoods orderGoods : orderGoodsList) {
                Long goodsId = orderGoods.getGoods().getId();
                // 남은 allGoodsId 중에서 굿즈를 팔기 위해서
                // 이미 산 굿즈는 allGoodsIdList에서 제거
                allGoodsIdList.remove(goodsId);
                countOrderedGoods++;
            }
        }
        // countCanOrderGoods(내가 사지 않은 굿즈 갯수) = 살 수 있는 최대 굿즈 개수 - 내가 산 goods 개수를 뺀 값
        int countCanOrderGoods = CAN_BUY_MAX_GOODS - countOrderedGoods;

        // 8개 초과 살 수 없음
        if (countCanOrderGoods < festivalUserOrderDTO.getCountOrderGoods()){
            throw new FestivalUserOrderCountException();
        }

        if(allGoodsIdList.size() < festivalUserOrderDTO.getCountOrderGoods()){
            // 재고가 있는 굿즈들 중에서 랜덤하게 뽑아야 한다
            // 재고가 있는 굿즈는 3갠데 5개를 사고 싶을 때 에러가 발생함
            throw new OutOfStockException();
        }
        // 공직자는 전체 갯수의 30%만 살 수 있음
        validatePublicOrderQuantity(festivalUser, festivalUserOrderDTO.getCountOrderGoods());

        // 랜덤하게 팔 randomGoodsId 목록
        Collections.shuffle(allGoodsIdList);
        ArrayList<Long> randomGoodsIdList = new ArrayList<>(allGoodsIdList.subList(0, festivalUserOrderDTO.getCountOrderGoods()));


        // 행사 주최 유저 찾기
        CityHallUser cityHallUser = (CityHallUser) userRepository
                .findById(festivalUserOrderDTO.getCityHallUserId())
                .orElseThrow(UserNotFoundException::new);

        List<OrderGoods> orderGoodsList = new ArrayList<>();

        int totalOrderPrice = 0;

        // OrderGoodsList
        for (Long goodsId : randomGoodsIdList){
            Goods goods = goodsService.findGoods(goodsId);

            // 할인된 굿즈 가격
            int discountPrice = festivalUserDiscountPolicy
                    .calculateDiscountPrice(festivalUser, goods.getPrice());
            int orderPrice = goods.getPrice() - discountPrice;

            goods.subStockQuantity(1);
            totalOrderPrice += orderPrice;

            OrderGoods orderGoods = OrderGoods.builder()
                    .orderPrice(orderPrice)
                    // 굿즈 1종류당 1개밖에 못 삼
                    .count(1)
                    .goods(goods)
                    .build();
            orderGoodsRepository.save(orderGoods);

            orderGoodsList.add(orderGoods);
        }

        // 주문 가격이 0원 이하일 시 에러
        if (totalOrderPrice < 0){
            throw new OrderPriceException();
        }
        cityHallUser.Sell(totalOrderPrice);

        Order order = Order.builder()
                .user(festivalUser)
                .orderGoodsList(orderGoodsList)
                .build();

        return orderRepository.save(order).getId();
    }

    private void validatePublicOrderQuantity(FestivalUser festivalUser, int countOrderGoods) {
        List<FestivalUser> allPublicUsers = festivalUserRepository
                .findAllByRole(Role.PUBLIC);

        List<FestivalUser> allGeneralUsers = festivalUserRepository
                .findAllByRole(Role.GENERAL);

        int totalPublicOrderGoods = 0;
        int totalGeneralOrderGoods = 0;

        for (FestivalUser oneFestivalUser : allPublicUsers){
            List<Order> orders = oneFestivalUser.getOrders();
            for(Order order : orders){
                // FestivalUser는 orderGoods 개수 = goods 개수
                List<OrderGoods> orderGoodsList = order.getOrderGoodsList();
                totalPublicOrderGoods += orderGoodsList.size();
            }
        }

        for (FestivalUser oneFestivalUser : allGeneralUsers){
            List<Order> orders = oneFestivalUser.getOrders();
            for(Order order : orders){
                // FestivalUser는 orderGoods 개수 = goods 개수
                List<OrderGoods> orderGoodsList = order.getOrderGoodsList();
                totalGeneralOrderGoods += orderGoodsList.size();
            }
        }

        // totalPublicOrderGoods -> 공직자가 지금까지 산 굿즈 개수
        if(festivalUser.getRole().equals(Role.PUBLIC)){
            if (100 * (totalPublicOrderGoods + countOrderGoods) / (totalPublicOrderGoods + countOrderGoods + totalGeneralOrderGoods) > 30){
                throw new PublicOrderException();
            }
        }
    }

    private OrderGoods createOrderGoodsFromDTO(OrderGoodsDTO orderGoodsDTO, Goods goods) {
        return OrderGoods.builder()
                .count(orderGoodsDTO.getCount())
                .goods(goods)
                .build();
    }

}
