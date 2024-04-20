package com.example.study.sticker.repository;

import com.example.study.sticker.domain.Sticker;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StickerMemoryRepository implements StickerRepository{

    private final HashMap<String, Sticker> stickerHashMap = new HashMap<>();

    @Override
    public void save(Sticker sticker) {
        stickerHashMap.put(sticker.getName(), sticker);
    }

    @Override
    public Optional<Sticker> find(String name) {
        return Optional.of(stickerHashMap.get(name));
    }

    @Override
    public List<Sticker> findAll() {
        Set<String> keys = stickerHashMap.keySet();
        List<Sticker> stickers = new ArrayList<>();

        for(String key : keys){
            Sticker sticker = stickerHashMap.get(key);
            stickers.add(sticker);
        }

        return stickers;
    }
}
