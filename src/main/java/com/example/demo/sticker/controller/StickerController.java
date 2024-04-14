package com.example.demo.sticker.controller;

import com.example.demo.sticker.model.response.GetStickerStockResponse;
import com.example.demo.sticker.service.GetStickerStockUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StickerController {
    private final GetStickerStockUseCase getStickerStockUseCase;
    @GetMapping("/sticker/stock/{stickerId}")
    public ResponseEntity<GetStickerStockResponse> getStickerStock(@PathVariable Long stickerId) {
        GetStickerStockResponse response = getStickerStockUseCase.execute(stickerId);
        return ResponseEntity.ok(response);
    }
}
