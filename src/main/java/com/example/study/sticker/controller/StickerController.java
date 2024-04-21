package com.example.study.sticker.controller;

import com.example.study.city.domain.Region;
import com.example.study.city.dto.AddStickerRequest;
import com.example.study.city.dto.FindStickersResponse;
import com.example.study.sticker.dto.SellStickerRequest;
import com.example.study.sticker.service.GetStickerStockService;
import com.example.study.sticker.service.SellStickerService;
import com.example.study.sticker.service.BuyStickerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StickerController {

    private final BuyStickerService buyStickerService;
    private final SellStickerService sellStickerService;
    private final GetStickerStockService getStickerStockService;

    /**
     * 스티커 판매 API
     */
    @PatchMapping("/sticker")
    public ResponseEntity<Void> sell(@RequestBody SellStickerRequest sellStickerRequest){
        sellStickerService.execute(Region.남원.name(), sellStickerRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 스티커 구매 API
     */
    @PostMapping("/sticker")
    public ResponseEntity<Void> buy(@RequestBody AddStickerRequest addStickerRequest){
        buyStickerService.execute(Region.남원.name(), addStickerRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * 스티커 재고 조회 API
     */
    @GetMapping("/sticker")
    public ResponseEntity<FindStickersResponse> find(){
        FindStickersResponse findStickersResponse = getStickerStockService.execute(Region.남원.name());
        return new ResponseEntity<>(findStickersResponse, HttpStatus.OK);
    }



}
