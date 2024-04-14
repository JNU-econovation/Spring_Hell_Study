package com.example.demo.sticker.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Sticker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private Integer stock;

    public Sticker(String name, Integer stock) {
        this.name = name;
        this.stock = stock;
    }

    public Sticker(String name) {
        this.name = name;
    }
}
