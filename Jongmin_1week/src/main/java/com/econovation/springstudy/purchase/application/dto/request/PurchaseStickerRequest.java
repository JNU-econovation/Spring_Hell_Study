package com.econovation.springstudy.purchase.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PurchaseStickerRequest {

    private final Long count;

    private final String consumerType;

}
