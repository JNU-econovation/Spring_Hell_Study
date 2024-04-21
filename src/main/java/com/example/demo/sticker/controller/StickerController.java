package com.example.demo.sticker.controller;

import com.example.demo.sticker.model.request.CreateStickerRequest;
import com.example.demo.sticker.model.request.SetStickerPriceRequest;
import com.example.demo.sticker.model.request.SetStickerRankRequest;
import com.example.demo.sticker.model.response.CreateStickerResponse;
import com.example.demo.sticker.model.response.GetStickerStockResponse;
import com.example.demo.sticker.service.CreateStickerUseCase;
import com.example.demo.sticker.service.GetStickerStockUseCase;
import com.example.demo.sticker.service.SetStickerPriceUseCase;
import com.example.demo.sticker.service.SetStickerRankUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StickerController {
    private final GetStickerStockUseCase getStickerStockUseCase;
    private final SetStickerPriceUseCase setStickerPriceUseCase;
    private final SetStickerRankUseCase setStickerRankUseCase;
    private final CreateStickerUseCase createStickerUseCase;
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
    @PutMapping("/sticker/price/{stickerId}")
    public ResponseEntity<String> setStickerPrice(@PathVariable Long stickerId, @RequestBody SetStickerPriceRequest request) {
        setStickerPriceUseCase.execute(stickerId,request);
        return ResponseEntity.ok("가격 수정이 완료 되었습니다.");
    }

    @PutMapping("/sticker/rank/{stickerId}")
    public ResponseEntity<String> setStickerRank(@PathVariable Long stickerId, @RequestBody SetStickerRankRequest request) {
        setStickerRankUseCase.execute(stickerId,request);
        return ResponseEntity.ok("랭크 수정이 완료 되었습니다.");
    }

    /**
     * 스티커 재고 추가 (남원 인쇄소 -> 남원시청 스티커 배송)
     * @param request : 어떤 발주들을 성사 시킬건지(발주들의 id)
     * @return
     */
    @PostMapping("/sticker")
    public ResponseEntity<List<CreateStickerResponse>> createSticker(@RequestBody CreateStickerRequest request) {
        List<CreateStickerResponse> response = createStickerUseCase.execute(request);
        return ResponseEntity.ok(response);
    }
}
