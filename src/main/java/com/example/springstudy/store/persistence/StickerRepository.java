package com.example.springstudy.store.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StickerRepository extends JpaRepository<StickerEntity, Long> {
}
