package org.example.springstudy.service.discount;

import org.example.springstudy.domain.user.FestivalUser;
import org.example.springstudy.domain.user.UserBaseEntity;

public interface DiscountPolicy {
    int calculateDiscountPrice(UserBaseEntity userBaseEntity, int price);
}
