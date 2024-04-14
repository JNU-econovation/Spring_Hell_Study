package com.econovation.springstudy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuyGoodsDTO {
    @JsonProperty("sticker_id")
    private Long stickerId;
    private int number;

    public Long getStickerId() {
        return stickerId;
    }

    public BuyGoodsDTO() {
    }

    public int getNumber() {
        return number;
    }
}
