package com.econovation.springstudy.sticker.application.model;

import lombok.Getter;

@Getter
public enum StickerNames {

    NAMWON_TWO_SEASONING_CHINCKEN("namwon_two_seasoning_chicken"),
    NAMWON_STARBUCKS("namwon_starbucks"),
    NAMWON_POPULATION_75000("namwon_population_75000"),
    NAMWON_PARTY_SURVEY("namwon_party_survey"),
    NAMWON_DEAD_FISH("namwon_dead_fish"),
    NAMWON_JI_MOUNTAIN("namwon_ji_mountain");

    private String sticker;

    StickerNames(String sticker){ this.sticker = sticker; }

}
