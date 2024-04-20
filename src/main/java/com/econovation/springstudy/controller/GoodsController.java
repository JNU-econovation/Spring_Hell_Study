package com.econovation.springstudy.controller;


import com.econovation.springstudy.dto.goods.RestockGoodsReq;
import com.econovation.springstudy.dto.goods.CreateGoodsReq;
import com.econovation.springstudy.service.GoodsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsController {

    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    //굿즈 추가
    @PostMapping("/goods")
    public String createSticker(@RequestBody @Valid CreateGoodsReq goodsDTO){
        //TODO: 권한 확인 - 시청 직원
        goodsService.createGoods(goodsDTO);
        return "";
    }

    //재고 확인
    @GetMapping("/goods/{goods-id}")
    public String getTheGoodsNumber(@PathVariable("goods-id") Long goodsId){
        int goodsNumber = goodsService.getTheGoodsNumber(goodsId);

        return goodsId + "번 굿즈의 개수 : " +goodsNumber;
    }


    //판매 (남원 시청 -> 고객)
    @PostMapping("/buying")
    public String sellSticker(@RequestBody int number){

        return "";
    }

    //구매 (남원 시청 -> 남원 인쇄소)
    @PostMapping("/restocking")
    public String restockGoods(@RequestBody @Valid RestockGoodsReq restockGoodsReq){
        //TODO: 어노테이션으로 검증
        if (restockGoodsReq.getNumber() % 100 != 0)
            throw new IllegalArgumentException("스티커 개수는 100개 단위어야 함");
        goodsService.restockGoods(restockGoodsReq);
        return "";
    }

}
