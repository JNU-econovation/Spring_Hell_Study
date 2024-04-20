package com.example.study.city.dto;

import lombok.Builder;

import java.util.List;

public record BuyStickerRequest(
        List<BuyStickerDTO> buyStickerDTOS
) {

    @Builder
    public BuyStickerRequest {
    }
}
