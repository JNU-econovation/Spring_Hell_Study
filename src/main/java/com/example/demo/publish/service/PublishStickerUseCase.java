package com.example.demo.publish.service;

import com.example.demo.common.message.StaticMessage;
import com.example.demo.publish.domain.Publish;
import com.example.demo.publish.model.response.PublishStickerResponse;
import com.example.demo.publish.repository.PublishRepository;
import com.example.demo.publish.model.request.PublishStickerRequest;
import com.example.demo.sticker.domain.Sticker;
import com.example.demo.sticker.repository.StickerRepository;
import com.example.demo.user.domain.User;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublishStickerUseCase {
    private final UserRepository userRepository;
    private final PublishRepository publishRepository;
    private final StickerRepository stickerRepository;
    @Transactional
    public PublishStickerResponse execute(PublishStickerRequest request) {
        Long userId = request.userId();
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException(StaticMessage.NOT_FOUND_MEMBER));
        List<String> stickerNames =  request.stickers().stream()
                .map(publishDto -> {
                    checkQuantity(publishDto.getQuantity());
                    publishDto.sale(publishDto);
                    Publish publish = new Publish(user,publishDto.getQuantity(),publishDto.getStickerName(),publishDto.getPrice());
                    return publishRepository.save(publish);
                })
                .map(publish -> {
                  Sticker sticker = Sticker.builder().name(publish.getStickerName()).initialStock(publish.getQuantity()).build();
                  return stickerRepository.save(sticker);
                })
                .map(Sticker::getName)
                .toList();
        return new PublishStickerResponse(stickerNames);
    }
    private void checkQuantity(Integer quantity) {
        if(!quantity.equals(100))
            throw new IllegalArgumentException("100개씩 발주 넣을 수 있습니다");
    }
}
