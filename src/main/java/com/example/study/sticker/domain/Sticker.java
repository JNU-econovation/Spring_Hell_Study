package com.example.study.sticker.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Sticker {

    public static final Long PRICE = 100L;

    private String name;

    private Long stock;

    private Long price;

    @Builder
    public Sticker(String name, Long stock) {
        this.name = name;
        this.stock = stock;
        this.price = PRICE;
    }

    public static Sticker createSticker(String name, Long count){
        return Sticker.builder()
                .name(name)
                .stock(count)
                .build();
    }

    public Sticker updateStock(Long buyCount){
        return Sticker.builder()
                .stock(this.stock - buyCount)
                .name(this.name)
                .build();
    }



}
