package com.example.springstudy.store.application.model.converter;

import com.example.springstudy.common.support.converter.AbstractEntityConverter;
import com.example.springstudy.store.application.model.StickerModel;
import com.example.springstudy.store.persistence.StickerEntity;
import org.springframework.stereotype.Component;

@Component
public class StickerEntityConverter implements AbstractEntityConverter<StickerEntity, StickerModel> {

    @Override
    public StickerModel from(StickerEntity stickerEntity) {
        return null;
    }

    @Override
    public StickerEntity toEntity(StickerModel source) {
        return StickerEntity.builder()
                .stickerId(source.getStickerId())
                .stickerPrice(source.getStickerPrice())
                .stickerStock(source.getStickerStock())
                .build();
    }
}
