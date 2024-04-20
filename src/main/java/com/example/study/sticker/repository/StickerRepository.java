package com.example.study.sticker.repository;

import com.example.study.sticker.domain.Sticker;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface StickerRepository {

    void save(Sticker sticker);

    Optional<Sticker> find(String name);

    List<Sticker> findAll();
}
