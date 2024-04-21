package com.econovation.springstudy.dto.goods;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BuyGoodsRes {
    private final Long goodsId;
    private final String name;
    private final int boughtNumber;

    public BuyGoodsRes(Long goodsId, String name, int boughtNumber) {
        this.goodsId = goodsId;
        this.name = name;
        this.boughtNumber = boughtNumber;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public String getName() {
        return name;
    }

    public int getBoughtNumber() {
        return boughtNumber;
    }
}
