package com.econovation.springstudy.purchase.controller;

import com.econovation.springstudy.purchase.application.dto.request.PurchaseStickerRequest;
import com.econovation.springstudy.common.application.dto.reponse.ApiResponse;
import com.econovation.springstudy.common.application.dto.ApiUtils;
import com.econovation.springstudy.purchase.application.dto.response.QueryStrickerResponse;
import com.econovation.springstudy.purchase.application.usecase.PurchaseStickerUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stickers")
public class PurchsaeController {

    private final PurchaseStickerUsecase purchaseStickerUsecase;

//    @GetMapping
//    public ApiResponse<SuccessBody<List<QueryStrickerResponse>>> getStickers(){
//
//    }

    @PostMapping("/{stickerId}")
    public ApiResponse<QueryStrickerResponse> purchaseSticker(
            @RequestBody PurchaseStickerRequest request
            ){
        QueryStrickerResponse response = purchaseStickerUsecase.purchase(request);
        return ApiUtils.successBody("200", "성공", response);
    }
}
