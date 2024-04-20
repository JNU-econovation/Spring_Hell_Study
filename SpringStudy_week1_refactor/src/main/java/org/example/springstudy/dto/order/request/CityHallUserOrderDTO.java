package org.example.springstudy.dto.order.request;

import lombok.Getter;

import java.util.List;

@Getter
public class CityHallUserOrderDTO {
    private Long userId;
    private List<OrderGoodsDTO> orderGoodsDTOList;
}
