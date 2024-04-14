package com.econovation.springstudy.sticker.application.model.converter;

import com.econovation.springstudy.sticker.application.model.StickerModel;
import com.econovation.springstudy.sticker.entity.StickerEntity;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class StickerModelConverter {

    public StickerModel from(StickerEntity entity){
        return new StickerModel(
                entity.getId(),
                entity.getName(),
                entity.getRemain(),
                entity.getPrice()
        );
    }

}
