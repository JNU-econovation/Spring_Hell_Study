package com.example.demo.sticker.domain;

public enum StickerRank {
    SSR("SSR"),
    SR("SR"),
    S("S"),
    A("A"),
    B("B"),
    C("C"),
    FNG("짬찌")
    ;
    private final String value;
    StickerRank(String value) {
        this.value = value;
    }
}
