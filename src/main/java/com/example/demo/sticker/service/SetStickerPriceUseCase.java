package com.example.demo.sticker.service;

import com.example.demo.common.message.StaticMessage;
import com.example.demo.sticker.domain.Sticker;
import com.example.demo.sticker.model.request.SetStickerPriceRequest;
import com.example.demo.sticker.repository.StickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SetStickerPriceUseCase {
    private final StickerRepository stickerRepository;
    @Transactional
    public void execute(Long stickerId, SetStickerPriceRequest request) {
        Sticker sticker = stickerRepository.findById(stickerId)
                .orElseThrow(() -> new IllegalArgumentException(StaticMessage.NOT_FOUND_STICKER));
        sticker.updatePrice(request.price());
    }
}
