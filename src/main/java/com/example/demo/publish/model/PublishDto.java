package com.example.demo.publish.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PublishDto {
    private String stickerName;
    private Integer quantity;
    private Integer price; // 스티커 발주 1개당 가격 -> 여기서는 100개당 10000원이니 1개당 100원
    public static PublishDto of(String name, Integer quantity, Integer price) {
        return new PublishDto(name,quantity,price);
    }

    public void sale(PublishDto publishDto) {
        if(publishDto.getQuantity().equals(1000))
           this.price = (this.price * 3) / 4;
    }
}
