package com.econovation.springstudy.purchase.controller;

import com.econovation.springstudy.purchase.application.dto.request.PurchaseStickerRequest;
import com.econovation.springstudy.common.application.dto.reponse.ApiResponse;
import com.econovation.springstudy.common.application.dto.ApiUtils;
import com.econovation.springstudy.purchase.application.dto.response.QueryStickerResponse;
import com.econovation.springstudy.purchase.application.dto.response.QueryStickersResponse;
import com.econovation.springstudy.purchase.application.usecase.PurchaseStickerUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stickers")
public class PurchsaeController {

    private final PurchaseStickerUsecase purchaseStickerUsecase;

    @PostMapping("/{stickerId}")
    public ApiResponse<QueryStickersResponse> purchaseSticker(
            @RequestBody PurchaseStickerRequest request
            ){
        QueryStickersResponse response = purchaseStickerUsecase.purchase(request);
        return ApiUtils.successBody(response);
    }
}
