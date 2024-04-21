package com.econovation.springstudy.dto.goods;


import com.econovation.springstudy.config.enums.GoodsType;
import com.econovation.springstudy.config.enums.StickerLevel;
import com.econovation.springstudy.entity.Goods;
import com.econovation.springstudy.entity.Sticker;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateStickerReq extends CreateGoodsReq{
    @NotNull
    private final StickerLevel stickerLevel;

    public StickerLevel getStickerLevel() {
        return stickerLevel;
    }

    @Override
    public Goods toEntity() {
        return Sticker.builder()
                .name(this.name)
                .remaining(this.remaining)
                .sellingPrice(this.sellingPrice)
                .goodsType(this.goodsType)
                .stickerLevel(this.stickerLevel)
                .build();
    }

    public CreateStickerReq(String name, Integer remaining, Integer sellingPrice, GoodsType goodsType, StickerLevel stickerLevel) {
        super(name, remaining, sellingPrice, goodsType);
        this.stickerLevel = stickerLevel;
    }

    @Override
    public String toString() {
        return "CreateStickerReq{" +
                "stickerLevel=" + stickerLevel +
                ", name='" + name + '\'' +
                ", remaining=" + remaining +
                ", sellingPrice=" + sellingPrice +
                ", goodsType=" + goodsType +
                '}';
    }
}
