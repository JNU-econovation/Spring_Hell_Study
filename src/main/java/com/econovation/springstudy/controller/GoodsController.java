package com.econovation.springstudy.controller;


import com.econovation.springstudy.NamwonCity;
import com.econovation.springstudy.dto.goods.*;
import com.econovation.springstudy.service.GoodsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodsController {

    private final GoodsService goodsService;
    private final NamwonCity namwonCity;

    public GoodsController(GoodsService goodsService, NamwonCity namwonCity) {
        this.goodsService = goodsService;
        this.namwonCity = namwonCity;
    }

    //굿즈 추가
    @PostMapping("/goods")
    public String createGoods(@RequestBody @Valid CreateGoodsReq goodsDTO){
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
    //TODO: 굿즈 타입에 따라서 재고 확인할 수 있는 api

    @GetMapping("/goods")
    public List<GoodsInfoRes> getGoodsNumbers(){
        return goodsService.getGoodsNumbers();
    }

    //판매 (남원 시청 -> 고객)
    @PostMapping("/buying")
    public List<BuyGoodsRes> sellGoods(@RequestBody @Valid BuyGoodsReq buyGoodsReq){
        return goodsService.sellGoods(buyGoodsReq);
    }

    //구매 (남원 시청 -> 남원 인쇄소)
    @PostMapping("/restocking")
    public String restockGoods(@RequestBody @Valid RestockGoodsReq restockGoodsReq){
        //TODO: 어노테이션으로 검증
        if (restockGoodsReq.getNumber() % 100 != 0)
            throw new IllegalArgumentException("스티커 개수는 100개 단위어야 함");
        goodsService.restockGoods(restockGoodsReq);
        return "잔고: "+ namwonCity.checkBalance();
    }

}
