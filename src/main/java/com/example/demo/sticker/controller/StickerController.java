package com.example.demo.sticker.controller;

import com.example.demo.sticker.model.request.SetStickerPriceRequest;
import com.example.demo.sticker.model.response.GetStickerStockResponse;
import com.example.demo.sticker.service.GetStickerStockUseCase;
import com.example.demo.sticker.service.SetStickerPriceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StickerController {
    private final GetStickerStockUseCase getStickerStockUseCase;
    private final SetStickerPriceUseCase setStickerPriceUseCase;
    @GetMapping("/sticker/stock/{stickerId}")
    public ResponseEntity<GetStickerStockResponse> getStickerStock(@PathVariable Long stickerId) {
        GetStickerStockResponse response = getStickerStockUseCase.execute(stickerId);
        return ResponseEntity.ok(response);
    }

    /**
     * 가격 설정
     * @param stickerId
     * @param request
     * @return
     */
    @PostMapping("/sticker/price/{stickerId}")
    public ResponseEntity<String> setStickerPrice(@PathVariable Long stickerId, @RequestBody SetStickerPriceRequest request) {
        setStickerPriceUseCase.execute(stickerId,request);
        return ResponseEntity.ok("가격 수정이 완료 되었습니다.");
    }
}
