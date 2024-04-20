package com.example.study.city.dto;

import lombok.Builder;

public record StickerDTO(
        String name,
        Long count
) {

    @Builder
    public StickerDTO {
    }
}
