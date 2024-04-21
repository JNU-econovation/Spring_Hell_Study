package com.example.demo.sticker.model.response;

import lombok.Builder;

@Builder
public record CreateStickerResponse(String stickerName, Integer quantity) {
    public static CreateStickerResponse of(String stickerName, Integer quantity) {
        return CreateStickerResponse.builder()
                .stickerName(stickerName)
                .quantity(quantity)
                .build();
    }
}
