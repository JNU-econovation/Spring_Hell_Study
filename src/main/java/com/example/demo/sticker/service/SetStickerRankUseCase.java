package com.example.demo.sticker.service;

import com.example.demo.sticker.domain.StickerRank;
import com.example.demo.sticker.model.request.SetStickerRankRequest;
import com.example.demo.sticker.repository.StickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SetStickerRankUseCase {
    private final StickerRepository stickerRepository;
    @Transactional
    public void execute(Long stickerId, SetStickerRankRequest request) {
        stickerRepository.findById(stickerId).ifPresent(sticker -> {
            sticker.updateRank(StickerRank.valueOf(request.rank()));
        });
    }
}
