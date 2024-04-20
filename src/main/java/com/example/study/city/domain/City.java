package com.example.study.city.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class City {

    private String name;
    private Long budget;
    private List<String> stickerNames;

    @Builder
    public City(String name, Long budget, List<String> stickerNames) {
        this.name = name;
        this.budget = budget;
        this.stickerNames = stickerNames;
    }

    public City updateBudget(Long price){
        return City.builder()
                .name(this.name)
                .budget(this.budget - price)
                .stickerNames(this.stickerNames)
                .build();
    }
}
