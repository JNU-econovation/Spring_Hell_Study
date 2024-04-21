package com.econovation.springstudy.purchase.application.usecase;

import com.econovation.springstudy.purchase.application.dto.request.PurchaseStickerRequest;
import com.econovation.springstudy.purchase.application.dto.response.QueryStickerResponse;
import com.econovation.springstudy.purchase.application.dto.response.QueryStickersResponse;

public interface PurchaseStickerUsecase {

    public QueryStickersResponse purchase(PurchaseStickerRequest request);

}
