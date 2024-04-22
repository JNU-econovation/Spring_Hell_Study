package com.econovation.springstudy.order;

import com.econovation.springstudy.goods.BaseGoods;

import java.util.List;

// 상품 ID, 상품 이름, 갯수를 받아와
// 재고를 확인하고 있으면 판매, 1인당 8개 까지 판매 가능, 스티커는 랜덤으로 판매
// 공직자의 경우 10% 할인, 전체 갯수의 30% 까지 공직자 금액으로 판매 가능
public interface OrderService {
    Order createOrder(Long goodsId,String goodsName,int quantity);
    
    void sellGoods(int quantity); // 상품 판매
    boolean checkSaleLimit(int totalQuantity, int requestedQuantity); // 1인당 8개 제한 체크
    boolean discount(int quantity); // 공직자 할인 혜택 적용
    
    int getTotalStock(); // 전체 상품 수량 가져오기

    void addGoodsStock(Long id,int quantity);
}
