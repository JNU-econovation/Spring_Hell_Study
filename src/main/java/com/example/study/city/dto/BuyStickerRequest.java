package com.example.study.city.dto;

import lombok.Builder;

import java.util.List;

public record BuyStickerRequest(
        List<StickerDTO> buyStickerDTOS
) {

    @Builder
    public BuyStickerRequest {
    }
}
