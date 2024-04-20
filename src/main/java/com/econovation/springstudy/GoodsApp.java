package com.econovation.springstudy;

import com.econovation.springstudy.goods.BaseGoods;
import com.econovation.springstudy.goods.GoodsService;
import com.econovation.springstudy.goods.GoodsServiceImpl;
import com.econovation.springstudy.goods.NamwonGoods;
import com.econovation.springstudy.order.OrderService;
import com.econovation.springstudy.order.OrderServiceImpl;

import java.util.Random;

// Goods의 생성 및 조회, 재고 확인 테스트
public class GoodsApp {
    public static void main(String[] args) {
        GoodsService goodsService = new GoodsServiceImpl();

        // DB 적용은 선택 - 하는 법도 숙지하도록 해야겠다.
        // <T> 이거 사용하면 리스트 형식으로 반복문으로 생성 및 서비스에 등록 가능할듯하다. -> 우선은 전체적인 구현에 집중하고자 한다.
        BaseGoods goods1 = new NamwonGoods(1L,"남원 두마리 양념치킨 스티커",100,1000);
        BaseGoods goods2 = new NamwonGoods(2L,"남원 스타벅스 창립 기념 스티커",100,1000);
        BaseGoods goods3 = new NamwonGoods(3L,"남원시 인구 75000명 달성 기념 스티커",100,1000);
        BaseGoods goods4 = new NamwonGoods(4L,"남원시 정당 선호 조사 기념 스티커",100,1000);
        BaseGoods goods5 = new NamwonGoods(5L,"남원 양림단지 붕어 단체 사망 기념 스티커",100,1000);
        BaseGoods goods6 = new NamwonGoods(6L,"남원 지리산 애기봉 완봉 스티커",100,1000);

        goodsService.createGoods(goods1);
        goodsService.createGoods(goods2);
        goodsService.createGoods(goods3);
        goodsService.createGoods(goods4);
        goodsService.createGoods(goods5);
        goodsService.createGoods(goods6);

        BaseGoods findGoods = goodsService.findGoodsById(1L);
//        System.out.println("new Goods = " + goods1.getName());
//        System.out.println("find Goods = " + findGoods.getName());
//        System.out.println("find Goods stock = " + goodsService.getGoodsStock(1L));

        OrderService orderService = new OrderServiceImpl();
        Random random = new Random();
        orderService.getTotalStock();
        for(int i=0; i<500; i++){
            orderService.sellGoods(random.nextInt(1)+1);
            System.out.println("============================");
        }

    }
}
