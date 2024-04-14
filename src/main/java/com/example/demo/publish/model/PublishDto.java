package com.example.demo.publish.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PublishDto {
    private String stickerName;
    private Integer quantity;
    private Integer price;
    public static PublishDto of(String name, Integer quantity, Integer price) {
        return new PublishDto(name,quantity,price);
    }

    public void sale(PublishDto publishDto) {
        if(publishDto.getQuantity().equals(1000))
           this.price = (this.price * 3) / 4;
    }
}
