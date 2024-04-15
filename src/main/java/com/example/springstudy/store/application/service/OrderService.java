package com.example.springstudy.store.application.service;

import com.example.springstudy.store.application.dto.addStickerRequest;
import com.example.springstudy.store.application.model.StickerModel;
import com.example.springstudy.store.application.model.converter.StickerEntityConverter;
import com.example.springstudy.store.application.model.converter.StickerRequestConverter;
import com.example.springstudy.store.application.usecase.AddSticker;
import com.example.springstudy.store.persistence.StickerEntity;
import com.example.springstudy.store.persistence.StickerQuantityEntity;
import com.example.springstudy.store.persistence.StickerQuantityRepository;
import com.example.springstudy.store.persistence.StickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService implements AddSticker {

    private final StickerRepository stickerRepository;
    private final StickerRequestConverter requestConverter;
    private final StickerEntityConverter entityConverter;
    private final StickerQuantityRepository stickerQuantityRepository;

    @Override
    @Transactional
    public void add(StickerEntity sticker, StickerQuantityEntity quantity) {
        StickerModel model = requestConverter.from(request);
        StickerEntity entity = entityConverter.toEntity(model);
        stickerRepository.save(entity);
//        StickerEntity savaSticker = stickerRepository.save(sticker);
//        StickerQuantityEntity stickerQuantity = new StickerQuantityEntity();

    }




}
