package com.example.study.sticker.domain;

import java.util.List;

public class Stickers {

    private List<Sticker> stickers;

    private Stickers(List<Sticker> stickers) {
        this.stickers = stickers;
    }

    public static Stickers createStickers(List<Sticker> stickers){
        return new Stickers(stickers);
    }

    // 랜덤으로 재고 결정, 단 각 스티커 재고 안에 있어야한다.

    // 각 스티커당 재고가 몇 개 있는 지 Map으로 표현

    public void choiceRandomStickers(){





    }





}
