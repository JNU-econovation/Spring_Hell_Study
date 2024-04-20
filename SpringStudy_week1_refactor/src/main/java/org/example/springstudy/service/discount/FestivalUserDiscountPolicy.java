package org.example.springstudy.service.discount;

import org.example.springstudy.domain.user.FestivalUser;
import org.example.springstudy.domain.user.Role;
import org.example.springstudy.domain.user.UserBaseEntity;
import org.springframework.stereotype.Component;

@Component
public class FestivalUserDiscountPolicy{
    private final int DISCOUNT_PERCENT = 10;

    public int calculateDiscountPrice(FestivalUser festivalUser, int orderPrice) {
        if (festivalUser.getRole().equals(Role.PUBLIC)){
            return (orderPrice * DISCOUNT_PERCENT) / 100;
        } else {
            return 0;
        }
    }
}
