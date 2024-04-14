package com.econovation.springstudy.dto;


import com.econovation.springstudy.entity.Goods;

public class CreateGoodsDTO {
    private String name;
    private int remaining;

    public CreateGoodsDTO() {
    }

    public CreateGoodsDTO(String name, int remaining) {
        this.name = name;
        this.remaining = remaining;
    }

    public String getName() {
        return name;
    }

    public int getRemaining() {
        return remaining;
    }

    public Goods toEntity(){
        return new Goods(name, remaining);
    }

}
