package com.econovation.springstudy.dto.goods;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuyGoodsReq {
    @JsonProperty("sticker_id")
    private Long stickerId;
    private int number;

    public Long getStickerId() {
        return stickerId;
    }

    public BuyGoodsReq() {
    }

    public int getNumber() {
        return number;
    }
}
