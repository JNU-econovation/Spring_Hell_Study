package com.example.study.printer.domain;

import org.springframework.stereotype.Component;

@Component
public class Printer {

    // 100개 기준 스티커 가격
    private Long stickerPrice = 10000L;

    // 1000개당 할인 가격
    private Long salePrice = 25000L;

    private final Long sellingUnit = 100L;

    // 개수 -> 가격
    // 이때 할인 적용
    public Long getStickerPrice(Long count){

        if(count % sellingUnit != 0){
            throw new IllegalArgumentException("100개 단위로 요청을 받을 수 있습니다.");
        }
        Long units = count / sellingUnit;
        Long originalPrice = units * stickerPrice;
        Long discountPrice = discount(count);
        return originalPrice - discountPrice;

    }

    private Long discount(Long count){
        if(count >= 1000){
            Long units = count / 1000;
            return salePrice * units;
        }
        return 0L;
    }

}
