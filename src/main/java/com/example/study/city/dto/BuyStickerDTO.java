package com.example.study.city.dto;

import lombok.Builder;

public record BuyStickerDTO(
        String name,
        Long count
) {

    @Builder
    public BuyStickerDTO {
    }
}
