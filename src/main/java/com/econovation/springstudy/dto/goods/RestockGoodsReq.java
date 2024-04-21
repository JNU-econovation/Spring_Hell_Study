package com.econovation.springstudy.dto.goods;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RestockGoodsReq {
    @NotNull
    private final Long goodsId;
    @NotNull
    private final int number;

    public Long getGoodsId() {
        return goodsId;
    }

    public int getNumber() {
        return number;
    }

    public RestockGoodsReq(Long goodsId, int number) {
        this.goodsId = goodsId;
        this.number = number;
    }

}
