package org.example.springstudy.dto.goods.request;

import lombok.Getter;

@Getter
public class CreateGoodsDTO {
    private int price;
    private int stockQuantity;
    private String categoryName;
}
