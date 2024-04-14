package com.example.demo.sticker.service;

import com.example.demo.sticker.domain.Sticker;
import com.example.demo.sticker.model.response.GetStickerStockResponse;
import com.example.demo.sticker.repository.StickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
public class GetStickerStockUseCase {
    private final StickerRepository stickerRepository;

    public GetStickerStockResponse execute(Long stickerId) {
        Sticker sticker = stickerRepository.findById(stickerId).orElseThrow(() -> new IllegalArgumentException("Not found Sticker"));
        return new GetStickerStockResponse(sticker.getName(),sticker.getStock());
    }

}
