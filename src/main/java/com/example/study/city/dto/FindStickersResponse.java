package com.example.study.city.dto;

import java.util.List;

public record FindStickersResponse(
        List<StickerDTO> stickerDTOs
) {
}
