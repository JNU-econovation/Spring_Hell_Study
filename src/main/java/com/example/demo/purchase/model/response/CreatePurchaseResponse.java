package com.example.demo.purchase.model.response;

import lombok.Builder;

@Builder
public record CreatePurchaseResponse(Integer totalPrice, String StickerName, Integer Quantity) {
    public static CreatePurchaseResponse of(Integer totalPrice, String StickerName, Integer Quantity) {
        return CreatePurchaseResponse.builder()
                .totalPrice(totalPrice)
                .StickerName(StickerName)
                .Quantity(Quantity)
                .build();
    }
}
