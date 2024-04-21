package com.econovation.springstudy.purchase.application.dto.response;

import com.econovation.springstudy.sticker.application.model.StickerModel;

public class QueryStickerResponse {

    private Long stickerId;
    private String stickerName;
    private Long remain;
    private Long price;

    public QueryStickerResponse(String stickerName, Long remain, Long price){
        this.stickerName = stickerName;
        this.remain = remain;
        this.price = price;
    }

    public static QueryStickerResponse of(StickerModel model){
        return new QueryStickerResponse(model.getName(), model.getRemain(), model.getPrice());
    }

}
