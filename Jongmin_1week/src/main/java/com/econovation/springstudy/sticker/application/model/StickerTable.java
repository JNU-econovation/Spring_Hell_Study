package com.econovation.springstudy.sticker.application.model;

import com.econovation.springstudy.sticker.application.model.converter.StickerModelConverter;
import com.econovation.springstudy.sticker.repository.StickerRepository;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;


/**
 * StickerTable은, 전체 스티커 중 하나의 스티커를 랜덤으로 선택하기 위해
 * 키, 값이 아래와 같은 HashMap을 가지는 클래스입니다.
 * key -> 스티커의 수량
 * value -> 스티커의 객체
 */
@Component
public class StickerTable {

    private Map<Long, StickerModel> table;
    private StickerModelConverter converter;

    private final StickerRepository stickerRepository;

    public StickerTable(StickerRepository stickerRepository){
        this.stickerRepository = stickerRepository;
        this.table = rebuild(buildTable());
    }

    private Map<StickerModel, Long> buildTable(){
        return stickerRepository.findAll().stream()
                .collect(Collectors.toMap( model -> converter.from(model), model-> model.getRemain()));
    }

    private Map<Long, StickerModel> rebuild(Map<StickerModel, Long> map){
        List<Long> values = map.values().stream().toList();
        values.sort(Comparator.naturalOrder());

        Long sum = 0L;

        for(int i=0; i<values.size(); i++){
            Long value = values.get(i);
            sum += value;
            values.set(i, sum);
        }

        List<StickerModel> keys = map.keySet().stream().toList();

        Map<Long, StickerModel> rebuiledMap = new HashMap<>();

        for(int i=0; i<keys.size(); i++){
            rebuiledMap.put(values.get(i), keys.get(i));
        }

        return rebuiledMap;
    }


}
