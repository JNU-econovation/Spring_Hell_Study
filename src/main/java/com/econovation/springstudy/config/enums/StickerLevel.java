package com.econovation.springstudy.config.enums;

public enum StickerLevel {
    //5,25,125,625,3125, // 15625, 78125
    SSR(5),
    SR(25),
    S(125),
    A(625),
    B(3125),
    C(15625),
    JJAMJJI(78125);


    private final int available;

    StickerLevel(int available) {
        this.available = available;
    }
}
