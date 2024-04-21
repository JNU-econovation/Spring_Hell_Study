package com.econovation.springstudy.sticker.application.model;

import com.econovation.springstudy.common.application.model.Model;
import lombok.Getter;

@Getter
public class StickerModel implements Model {

    private Long stickerId;
    private String name;
    private Long remain;
    private Long officialPurchasable;
    private Long nonOfficialPurchasable;
    private Long price;

    public StickerModel(Long stickerId, String name, Long remain, Long officialPurchasable, Long nonOfficialPurchasable, Long price){
        this.stickerId = stickerId;
        this.name = name;
        this.remain = remain;
        this.officialPurchasable = officialPurchasable;
        this.nonOfficialPurchasable = nonOfficialPurchasable;
        this.price = price;
    }
}
