package com.econovation.springstudy.sticker.application.service;

import com.econovation.springstudy.sticker.application.dto.request.AddInventoryRequest;
import com.econovation.springstudy.sticker.application.dto.response.AddInventoryResponse;
import com.econovation.springstudy.sticker.application.usecase.AddInventoryUsecase;
import com.econovation.springstudy.sticker.repository.StickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StickerService
            implements AddInventoryUsecase {

    private final StickerRepository stickerRepository;
    public AddInventoryResponse add(AddInventoryRequest request){
        /** 재고 추가 로직 */
        
    }
}
