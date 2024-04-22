package com.econovation.springstudy.goods;

public enum GoodsRank {
    SSR(5),
    SR(25),
    S(125),
    A(625),
    B(3125),
    C(3125),
    JJ(3125);

    private final int quantity;

    GoodsRank(int quantity){
        this.quantity = quantity;
    }

    // 해당 등급의 수량을 가져오는 메서드
    public int getQuantity(){
        return quantity;
    }
}
