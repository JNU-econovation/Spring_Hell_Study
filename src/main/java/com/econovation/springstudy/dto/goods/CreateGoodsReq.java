package com.econovation.springstudy.dto.goods;


import com.econovation.springstudy.config.enums.GoodsType;
import com.econovation.springstudy.entity.Goods;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, visible = true, property = "goods_type")
@JsonSubTypes({@JsonSubTypes.Type(value = CreateStickerReq.class, name = "STICKER")})
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public abstract class CreateGoodsReq {
    @NotNull
    protected String name;
    @NotNull
    protected Integer remaining;
    @NotNull
    protected Integer sellingPrice;
    @NotNull
    protected GoodsType goodsType;

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public String getName() {
        return name;
    }

    public int getRemaining() {
        return remaining;
    }

    public Integer getSellingPrice() {
        return sellingPrice;
    }

    public abstract Goods toEntity();

    public CreateGoodsReq(String name, Integer remaining, Integer sellingPrice, GoodsType goodsType) {
        this.name = name;
        this.remaining = remaining;
        this.sellingPrice = sellingPrice;
        this.goodsType = goodsType;
    }
}
