package com.econovation.springstudy.controller;


import com.econovation.springstudy.dto.BuyStickerDTO;
import com.econovation.springstudy.dto.CreateGoodsDTO;
import com.econovation.springstudy.service.StickerService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.*;

@RestController
public class StickerController {

    private final StickerService stickerService;

    public StickerController(StickerService stickerService) {
        this.stickerService = stickerService;
    }

    //굿즈 추가
    @PostMapping("/goods")
    public String createSticker(@RequestBody CreateGoodsDTO goodsDTO){
        //TODO: 권한 확인 - 시청 직원
        stickerService.createSticker(goodsDTO);
        return "";
    }

    //재고 확인
    @GetMapping("/goods/{sticker-id}")
    public String getTheStickerNumber(@PathVariable("sticker-id") Long stickerId){
        int stickerNumber = stickerService.getTheStickerNumber(stickerId);

        return stickerId + "번 스티커의 개수 : " +stickerNumber;
    }


    //판매 (남원 시청 -> 고객)
    @PostMapping("/selling")
    public String sellSticker(@RequestBody int number){

        return "";
    }

    //구매 (남원 시청 -> 남원 인쇄소)
    @PostMapping("/buying")
    public String buySticker(@RequestBody BuyStickerDTO buyStickerDTO){
        if (buyStickerDTO.getNumber() % 100 != 0)
            throw new IllegalArgumentException("스티커 개수는 100개 단위어야 함");
        stickerService.buySticker(buyStickerDTO);
        return "";
    }

}
