package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods,Long> {
    public Goods findByCategory(Category category);
}
