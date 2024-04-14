package com.example.demo.sticker.repository;

import com.example.demo.sticker.domain.Sticker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StickerRepository extends JpaRepository<Sticker,Long> {
}
