package com.econovation.springstudy.order;

public class Order {

    private Long goodsId;
    private String goodsName;
    private int goodsStock;

    public Order(Long goodsId, String goodsName, int goodsStock) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsStock = goodsStock;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public int getGoodsStock() {
        return goodsStock;
    }
}
