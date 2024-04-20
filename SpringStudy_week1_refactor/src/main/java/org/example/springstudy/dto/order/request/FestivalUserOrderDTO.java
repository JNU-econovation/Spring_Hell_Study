package org.example.springstudy.dto.order.request;

import lombok.Getter;

@Getter
public class FestivalUserOrderDTO {
    private Long userId;
    private Long cityHallUserId;
    private int countOrderGoods;
}
