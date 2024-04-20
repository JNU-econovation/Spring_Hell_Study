package org.example.springstudy.service.discount;

import org.example.springstudy.domain.user.CityHallUser;
import org.example.springstudy.domain.user.FestivalUser;
import org.example.springstudy.domain.user.UserBaseEntity;
import org.springframework.stereotype.Component;

@Component
public class CityHallUserDiscountPolicy{

    private final int DISCOUNT_AMOUNT = 25000;

    public int calculateDiscountPrice(int orderGoodsQuantity) {
        return (orderGoodsQuantity / 1000) * DISCOUNT_AMOUNT;
    }
}
