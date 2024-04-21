package com.econovation.springstudy.order;

import com.econovation.springstudy.goods.BaseGoods;
import com.econovation.springstudy.goods.GoodsRepository;
import com.econovation.springstudy.goods.NamwonGoods;
import com.econovation.springstudy.goods.NamwonGoodsRepository;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OrderServiceImpl implements OrderService {
    private static final int DISCOUNT_RATE = 10;
    private static final double SALE_LIMIT_RATE = 0.3;
    private static final int MAX_LIMIT_PER_PERSON = 8;
    
    private final GoodsRepository goodsRepository = new NamwonGoodsRepository();
    private int totalStock; // 전체 재고

    @Override
    public Order createOrder(Long goodsId, String goodsName, int quantity) {
        return new Order(goodsId,goodsName,quantity);
    }

    // quantity가 고정되어 있는 상태로 호출됨
    // 랜덤이 아니라 quantity에 2가 들어오면 앞에서 4종목만 2개씩 뽑아 8개를 맞춤
    // 1이 들어올 경우 전체 상품을 1개씩 판매후 다음 사람으로 넘어감
    // 어떻게 보면 골고루는 맞는데 랜덤으로 판매가 이뤄지는 상황은 아닌듯하다.
    @Override
    public void sellGoods(int quantity) {
        List<BaseGoods> goodsList = goodsRepository.findAll();

        // 전체 재고 확인
        updateTotalStock(goodsList);
        int maxLimit = 0;
        for(int i=0; i < goodsList.size(); i++){
            maxLimit += quantity;
            if(checkSaleLimit(MAX_LIMIT_PER_PERSON,maxLimit)){
                System.out.println("1인당 구매 갯수를 넘어섰습니다.");
                break;
            }
            BaseGoods goods = goodsList.get(i);
            if(goods.getStock() >= quantity){
                sellGoods(goods,quantity);
            }
        }

    }

    private void sellGoods(BaseGoods goods, int quantity){
        int currentStock = goods.getStock();
        if(currentStock < quantity){
            System.out.println("현재 남아있는 갯수가 주문 수량보다 적습니다.");
            return;
        }

        if(discount(quantity)){
            System.out.println("공직자 할인 " + DISCOUNT_RATE + "%가 적용되었습니다.");
        }

        // 재고 업데이트
        currentStock -= quantity;
        goods.setStock(currentStock);

        System.out.println(goods.getName() + "의 " + quantity + "개를 판매하였습니다. 남은 재고 : " + goods.getStock());
    }

    @Override
    public boolean checkSaleLimit(int totalQuantity, int quantity) {
        return totalQuantity < quantity;
    }

    // 공직자 할인을 각 제품별 전체 갯수로 체크해줘야한다.
    // 현재 전체 갯수에서 체크되는 중
    @Override
    public boolean discount(int quantity) {
        int getTotalStock = getTotalStock();
        return (double)quantity/totalStock <= getTotalStock * SALE_LIMIT_RATE;
    }

    // stream 사용 예시
    private void updateTotalStock(List<BaseGoods> goodsList){
        totalStock = goodsList.stream().mapToInt(BaseGoods::getStock).sum();
    }

    @Override
    public int getTotalStock() {
        List<BaseGoods> goodsList = goodsRepository.findAll();
        totalStock=0;
        for (BaseGoods baseGoods : goodsList) {
            totalStock += baseGoods.getStock();
        }
        return totalStock;
    }

    @Override
    public void addGoodsStock() {
        List<BaseGoods> goodsList = goodsRepository.findAll();
        for (BaseGoods baseGoods : goodsList) {
            // 상품의 재고가 100개 아래로 내려가면 100개씩 재발주
            if(baseGoods.getStock()<100){
                int currentStock = baseGoods.getStock();
                System.out.println(baseGoods.getName() + "을 추가로 100개 발주합니다.");
                currentStock += 100;
                baseGoods.setStock(currentStock);
                System.out.println("발주가 성공적으로 마무리 되었습니다.");
            }
        }
    }
}
