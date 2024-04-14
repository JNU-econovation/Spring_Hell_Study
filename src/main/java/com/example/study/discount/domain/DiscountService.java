package com.example.study.discount.domain;

import com.example.study.member.domain.MemberType;
import com.example.study.sticker.domain.Sticker;
import org.springframework.stereotype.Component;

@Component
public class DiscountService {

    public static final Long FIX_DISCOUNT_PRICE = 25000L;
    public static final Long FIX_DISCOUNT_COUNT = 1000L;

    public Long execute(Long count, MemberType memberType){
        Long originalPrice = Sticker.PRICE * count;
        Long discountPrice = originalPrice;
        if(count > FIX_DISCOUNT_COUNT){
            discountPrice = originalPrice - ((count % FIX_DISCOUNT_COUNT) * FIX_DISCOUNT_PRICE);
        }

        if(MemberType.isPublicOfficial(memberType)){
            discountPrice = Math.subtractExact(discountPrice, discountPrice / 10);
        }
        
        return discountPrice;
    }


}
