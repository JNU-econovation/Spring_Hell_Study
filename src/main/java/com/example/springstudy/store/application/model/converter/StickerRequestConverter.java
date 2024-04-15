package com.example.springstudy.store.application.model.converter;

import com.example.springstudy.common.support.converter.AbstractDtoConverter;
import com.example.springstudy.store.application.dto.addStickerRequest;
import com.example.springstudy.store.application.model.StickerModel;
import org.springframework.stereotype.Component;

@Component
public class StickerRequestConverter implements AbstractDtoConverter<addStickerRequest, StickerModel> {

    @Override
    public StickerModel from(addStickerRequest source) {
        return StickerModel.builder()
                .stickerPrice(source.getStickerPrice())
                .stickerStock(source.getStickerStock())
                .build();
    }
}
