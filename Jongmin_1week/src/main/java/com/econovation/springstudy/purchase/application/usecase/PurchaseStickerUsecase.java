package com.econovation.springstudy.purchase.application.usecase;

import com.econovation.springstudy.purchase.application.dto.request.PurchaseStickerRequest;
import com.econovation.springstudy.purchase.application.dto.response.QueryStrickerResponse;

public interface PurchaseStickerUsecase {

    public QueryStrickerResponse purchase(Long sickerId, PurchaseStickerRequest request);

    public QueryStrickerResponse purchase(PurchaseStickerRequest request);

}
