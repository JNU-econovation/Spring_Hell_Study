package com.example.study.sticker.dto;

import lombok.Builder;

public record BuyStickerRequest(
        String memberUUID,
        Long price,
        Long buyCount
) {

    @Builder
    public BuyStickerRequest {
    }
}
