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
    @Override
    public Order createOrder(Long goodsId, String goodsName, int quantity) {
        return new Order(goodsId,goodsName,quantity);
    }

    @Override
    public void sellGoods(int quantity) {
        List<BaseGoods> goodsList = goodsRepository.findAll();
        
        // 랜덤 구현은 좀더 생각해보기
        // Collections.shuffle(namwonGoodsList); // 랜덤으로 상품리스트 섞기
//        for(BaseGoods goods : namwonGoodsList){
//            System.out.println("goods = " + goods.getName());
//        }
        int currentStock; // 현재 재고 상태

        // 고객 별로 스티커 판매
        for(int i=0,count=0; count <= MAX_LIMIT_PER_PERSON; i++,count++){
            count += quantity;
            if(count >= MAX_LIMIT_PER_PERSON){
                System.out.println("1인당 8개까지 구매 할 수 있습니다.");
                break;
            }
            if(i > goodsList.size()){
                i=0;
            }
            BaseGoods goods = goodsList.get(i);
            currentStock = goods.getStock();
            if(currentStock < quantity){
                System.out.println("현재 남아있는 갯수가 주문 수량보다 적습니다.");
                break;
            }
            currentStock -= quantity;
            goods.setStock(currentStock);
            if(discount(quantity)){
                System.out.println("공직자 할인 " + DISCOUNT_RATE + "%가 적용되었습니다.");
            }
            System.out.println("goods"+ goodsList.get(i).getName() +" = "+goods.getStock() + " ; " + count);
        }

    }

    // sales에서 이것저것 다 넣었는데 아래 메서드로 체크하는 형식으로 바꾸기
    @Override
    public boolean checkSaleLimit(int totalQuantity, int requestedQuantity) {
        return false;
    }

    private int discountCount = 0;
    int totalStock;

    // 공직자 할인을 각 제품별 전체 갯수로 체크해줘야한다.
    // 현재 전체 갯수에서 체크되는 중
    @Override
    public boolean discount(int quantity) {
        discountCount += quantity;
        if(discountCount > totalStock*SALE_LIMIT_RATE){
            System.out.println("공직자 할인 이벤트가 종료되었습니다.");
            return false;
        }
        Random random = new Random();
        return random.nextInt(10)%2 ==0;
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
