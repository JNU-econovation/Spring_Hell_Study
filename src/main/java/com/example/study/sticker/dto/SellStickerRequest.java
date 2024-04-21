package com.example.study.sticker.dto;

import lombok.Builder;

public record SellStickerRequest(
        String memberName,

        Long money,
        Long count
) {

    @Builder
    public SellStickerRequest {
    }
}
