package com.example.study.sticker.dto;

import lombok.Builder;

public record AddStickerRequest(
        String name,
        Long count
) {

    @Builder
    public AddStickerRequest {
    }
}
