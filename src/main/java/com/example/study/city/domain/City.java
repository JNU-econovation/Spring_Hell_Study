package com.example.study.city.domain;

import com.example.study.sticker.domain.Sticker;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class City {

    private String name;
    private Long budget;
    private List<Sticker> stickers;

    @Builder
    public City(String name, Long budget, List<Sticker> stickers) {
        this.name = name;
        this.budget = budget;
        this.stickers = stickers;
    }

    public City updateBudget(Long price){
        return City.builder()
                .name(this.name)
                .budget(this.budget - price)
                .stickers(this.stickers)
                .build();
    }
}
