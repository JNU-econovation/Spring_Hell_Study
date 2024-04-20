package com.example.study.city.dto;

import lombok.Builder;

import java.util.List;

public record AddStickerRequest(
        List<StickerDTO> stickerDTOs
) {

    @Builder
    public AddStickerRequest {
    }
}
