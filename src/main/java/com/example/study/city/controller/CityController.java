package com.example.study.city.controller;

import com.example.study.city.dto.FindStickersResponse;
import com.example.study.city.service.CityService;
import com.example.study.city.dto.BuyStickerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    /**
     * 스티커 구매 API
     * @param buyStickerRequest
     * @return
     */
    @PostMapping("/sticker")
    public ResponseEntity<Void> buySticker(@RequestBody BuyStickerRequest buyStickerRequest){
        cityService.buy(buyStickerRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * 스티커 재고 조회 API
     */
    @GetMapping("/sticker")
    public ResponseEntity<FindStickersResponse> findStickers(){
        FindStickersResponse findStickersResponse = cityService.findStickers();
        return new ResponseEntity<>(findStickersResponse, HttpStatus.OK);
    }
}
