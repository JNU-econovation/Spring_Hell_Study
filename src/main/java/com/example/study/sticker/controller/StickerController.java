package com.example.study.sticker.controller;

import com.example.study.city.domain.Region;
import com.example.study.city.dto.BuyStickerRequest;
import com.example.study.city.dto.FindStickersResponse;
import com.example.study.city.service.CityService;
import com.example.study.sticker.service.StickerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StickerController {

    private final StickerService stickerService;
    private final CityService cityService;
    @PatchMapping("/sticker")
    public ResponseEntity<Void> buy(@RequestBody SellStickerRequest sellStickerRequest){
        stickerService.buy(sellStickerRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * 스티커 재고 조회 API
     */
    @GetMapping("/sticker")
    public ResponseEntity<FindStickersResponse> findStickers(){
        FindStickersResponse findStickersResponse = stickerService.findStickerStocks(Region.남원.name());
        return new ResponseEntity<>(findStickersResponse, HttpStatus.OK);
    }



}
