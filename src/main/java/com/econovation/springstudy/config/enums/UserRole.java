package com.econovation.springstudy.config.enums;

public enum UserRole {
    NONE(0),
    OFFICIAL(10);

    private final float discountRate;

    UserRole(float discountRate) {
        this.discountRate = discountRate;
    }

    public float getDiscountRate() {
        return discountRate;
    }
}
