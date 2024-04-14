package com.econovation.springstudy.purchase.application.service;

import com.econovation.springstudy.common.repositroy.Repositroy;
import com.econovation.springstudy.purchase.application.dto.request.PurchaseStickerRequest;
import com.econovation.springstudy.purchase.application.dto.response.QueryStrickerResponse;
import com.econovation.springstudy.sticker.application.model.StickerModel;
import com.econovation.springstudy.sticker.repository.StickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OfficialPurchaseService {

    private final StickerRepository repository;

    public QueryStrickerResponse purchase(PurchaseStickerRequest request){
        Long totalPrice = 0L;
        StickerModel model = getSticker();
        model.
    }

    private StickerModel getSticker(){
        return repository.get();
    }



}
