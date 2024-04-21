package com.econovation.springstudy.goods;

public interface BaseGoods {
    Long getId(); // 상품 아이디를 가져오는 메서드
    String getName();   // 상품 이름을 가져오는 메서드
    int getPrice(); // 가격을 가져오는 메서드
    int getStock(); // 재고를 가져오는 메서드
    void setStock(int stock); // 재고를 설정하는 메서드


}
