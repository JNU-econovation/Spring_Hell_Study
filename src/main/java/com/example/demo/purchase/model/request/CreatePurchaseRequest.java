package com.example.demo.purchase.model.request;

public record CreatePurchaseRequest
        (
         Long userId,

         Integer quantity // 인당 8개로 판매수를 제한합니다 -> 한사람당 최대 살 수 있는 스티커 수는 8개
          ) {

}
