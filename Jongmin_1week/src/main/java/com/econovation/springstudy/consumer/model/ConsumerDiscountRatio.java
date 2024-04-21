package com.econovation.springstudy.consumer.model;

import lombok.Getter;

@Getter
public enum ConsumerDiscountRatio {

    OFFICIAL(0.9),
    NON_OFFICIAL(1.0);

    private double ratio;

    ConsumerDiscountRatio(double ratio) { this.ratio = ratio; }

}
