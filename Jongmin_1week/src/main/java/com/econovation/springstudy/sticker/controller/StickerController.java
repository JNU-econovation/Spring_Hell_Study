package com.econovation.springstudy.sticker.controller;

import com.econovation.springstudy.common.application.dto.ApiUtils;
import com.econovation.springstudy.common.application.dto.reponse.ApiResponse;
import com.econovation.springstudy.sticker.application.dto.request.AddInventoryRequest;
import com.econovation.springstudy.sticker.application.dto.response.AddInventoryResponse;
import com.econovation.springstudy.sticker.application.usecase.AddInventoryUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stickers")
public class StickerController {

    private final AddInventoryUsecase usecase;

    @PostMapping("/{stickerId}")
    public ApiResponse<AddInventoryResponse> add(
            @PathVariable("{stickerId}") Long stickerId,
            @RequestBody AddInventoryRequest request
            ){
        AddInventoryResponse response = usecase.add(request);
        return ApiUtils.successBody("200", "성공", response);
    }

}
