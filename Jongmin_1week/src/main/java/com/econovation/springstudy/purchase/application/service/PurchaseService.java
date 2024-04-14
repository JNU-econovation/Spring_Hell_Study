package com.econovation.springstudy.purchase.application.service;

import com.econovation.springstudy.consumer.model.ConsumerTypes;
import com.econovation.springstudy.purchase.application.dto.request.PurchaseStickerRequest;
import com.econovation.springstudy.purchase.application.dto.response.QueryStrickerResponse;
import com.econovation.springstudy.purchase.application.exception.DeniedPurchaseException;
import com.econovation.springstudy.purchase.application.usecase.PurchaseStickerUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseService implements PurchaseStickerUsecase {

    private final OfficialPurchaseService officialPurchaseService;

//    public QueryStrickerResponse purchase(Long stickerId, PurchaseStickerRequest request){
//        /** 구매 로직
//         * 1. 소비자 타입이 무엇인가?
//         *   a. 소비자 타입이 공직자일 경우, 누적 구매 개수가 전체 스티커 개수 의 30%가 초과하는가?
//         * 2. 구매 개수가 9개 이상인가?
//         * 3. 위 과정을 만족한다면, 랜덤한 스티커를 제공*/
//
//
//    }

    public QueryStrickerResponse purchase(PurchaseStickerRequest request){
        checkCount(request);

    }

    private void checkCount(PurchaseStickerRequest request){
        if(request.getCount() > 9) throw new DeniedPurchaseException("1인당 최대 구매 수량은 8개 입니다.");
    }





}
