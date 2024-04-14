package com.econovation.springstudy.sticker.repository;

import com.econovation.springstudy.common.repositroy.Repositroy;
import com.econovation.springstudy.sticker.application.model.StickerModel;
import com.econovation.springstudy.sticker.application.model.converter.StickerModelConverter;
import com.econovation.springstudy.sticker.entity.StickerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RequiredArgsConstructor
@Component
public class StickerRepository implements Repositroy {

    /**
     * Key -> StickerId
     * Value -> Sticker
     */
    private Map<Long, StickerEntity> repository = new HashMap<>();
    private static Long maxId = 0L;

    private final StickerModelConverter converter;
    public StickerEntity add(StickerModel sticker){
        /**
         * 저장소에 추가하는 로직
         */
        maxId++;
    }

    public StickerModel get(){
        return converter.from(
                getRandomSticker()
        );
    }

    private StickerEntity getRandomSticker(){
        Random random = new Random();
        Long id = random.nextLong(1,maxId);
        return repository.get(id);
    }

}
