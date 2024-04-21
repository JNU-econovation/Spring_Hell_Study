package com.example.demo.sticker.service;

import com.example.demo.common.message.StaticMessage;
import com.example.demo.publish.domain.Publish;
import com.example.demo.publish.repository.PublishRepository;
import com.example.demo.sticker.domain.Sticker;
import com.example.demo.sticker.model.request.CreateStickerRequest;
import com.example.demo.sticker.model.response.CreateStickerResponse;
import com.example.demo.sticker.repository.StickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateStickerUseCase {
    private final PublishRepository publishRepository;
    private final StickerRepository stickerRepository;
    @Transactional
    public List<CreateStickerResponse> execute(CreateStickerRequest request) {
        return request.publishId().stream()
                .map(publishId -> publishRepository.findById(publishId)
                        .orElseThrow(() -> new IllegalArgumentException(StaticMessage.NOT_FOUND_PUBLISH)))
                .map(publish -> {
                    publish.updateIsConfirmed();
                    return stickerRepository.save(toSticker(publish));
                })
                .map(sticker -> CreateStickerResponse.of(sticker.getName(),sticker.getInitialStock()))
                .toList();
    }
    private Sticker toSticker(Publish publish) {
        return Sticker.builder().name(publish.getStickerName()).initialStock(publish.getQuantity()).build();
    }
}
