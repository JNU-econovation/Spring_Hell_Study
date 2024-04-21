package com.econovation.springstudy.dto.goods;

import com.econovation.springstudy.config.enums.GoodsType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;

//다른 굿즈를 추가하게 될 경우 사용
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, visible = true, property = "goods_type")
//@JsonSubTypes({@JsonSubTypes.Type(value = BuyGoodsReq.class, name = "STICKER")})
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BuyGoodsReq {
    @NotNull
    private Long userId;
    @NotNull
    private Integer numberToBuy;
    @NotNull
    private GoodsType goodsType;

    public Long getUserId() {
        return userId;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public Integer getNumberToBuy() {
        return numberToBuy;
    }

    public BuyGoodsReq(Long userId, Integer numberToBuy, GoodsType goodsType) {
        this.userId = userId;
        this.numberToBuy = numberToBuy;
        this.goodsType = goodsType;
    }
}
