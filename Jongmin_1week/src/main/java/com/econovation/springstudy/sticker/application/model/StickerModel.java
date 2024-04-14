package com.econovation.springstudy.sticker.application.model;

import com.econovation.springstudy.common.application.model.Model;

public class StickerModel implements Model {

    private Long stickerId;
    private String name;
    private Long remain;

    private Long price;

    public StickerModel(Long stickerId, String name, Long remain, Long price){
        this.stickerId = stickerId;
        this.name = name;
        this.remain = remain;
        this.price = price;
    }

}
