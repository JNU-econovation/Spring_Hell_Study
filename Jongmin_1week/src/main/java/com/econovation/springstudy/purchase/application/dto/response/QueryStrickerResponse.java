package com.econovation.springstudy.purchase.application.dto.response;

public class QueryStrickerResponse {

    private Long stickerId;
    private String stickerName;
    private Long remain;
    private Long price;

    public QueryStrickerResponse(String stickerName, Long remain, Long price){
        this.stickerName = stickerName;
        this.remain = remain;
        this.price = price;
    }

}
