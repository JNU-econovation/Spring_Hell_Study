package com.econovation.springstudy.sticker.repository;

import com.econovation.springstudy.sticker.entity.StickerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StickerRepository extends JpaRepository<StickerEntity, Long> {

    public Optional<StickerEntity> findById(Long id);

    public List<StickerEntity> findAll();


}
