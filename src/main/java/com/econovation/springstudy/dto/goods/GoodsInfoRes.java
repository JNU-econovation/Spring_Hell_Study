package com.econovation.springstudy.dto.goods;

import com.econovation.springstudy.config.enums.GoodsType;

public class GoodsInfoRes {
    private final Long goodsId;
    private final String name;
    private final int remaining;
    private final GoodsType goodsType;

    public GoodsInfoRes(Long goodsId, String name, int remaining, GoodsType goodsType) {
        this.goodsId = goodsId;
        this.name = name;
        this.remaining = remaining;
        this.goodsType = goodsType;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public String getName() {
        return name;
    }

    public int getRemaining() {
        return remaining;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }
}
