package com.econovation.springstudy.sticker.entity;

import com.econovation.springstudy.common.entity.Entity;

public class StickerEntity implements Entity {

    private Long id;
    private String name;
    private Long remain;
    private Long price;

    public StickerEntity(Long id, String name, Long remain, Long price){
        this.id = id;
        this.name = name;
        this.remain = remain;
        this.price = price;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Long getRemain() { return remain; }
    public Long getPrice() { return price; }
}
