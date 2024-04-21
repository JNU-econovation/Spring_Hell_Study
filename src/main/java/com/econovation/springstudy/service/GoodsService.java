package com.econovation.springstudy.service;

import com.econovation.springstudy.NamwonCity;
import com.econovation.springstudy.config.enums.GoodsType;
import com.econovation.springstudy.config.enums.StickerLevel;
import com.econovation.springstudy.config.enums.UserRole;
import com.econovation.springstudy.dto.goods.*;
import com.econovation.springstudy.entity.Goods;
import com.econovation.springstudy.entity.Sticker;
import com.econovation.springstudy.entity.User;
import com.econovation.springstudy.repository.GoodsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;


@Service
public class GoodsService {
    private final NamwonCity namwonCity;
    private final GoodsRepository goodsRepository;
    private final UserService userService;

    public GoodsService(NamwonCity namwonCity, GoodsRepository goodsRepository, UserService userService) {
        this.namwonCity = namwonCity;
        this.goodsRepository = goodsRepository;
        this.userService = userService;
    }

//-- 퍼사드 메서드?

    @Transactional
    public void createGoods(CreateGoodsReq createGoodsReq){
        Goods goods = createGoodsReq.toEntity();
        goodsRepository.save(goods);
    }

    @Transactional
    public void restockGoods(RestockGoodsReq restockGoodsReq){
        restockGoods(getGoodsOrThrow(restockGoodsReq.getGoodsId()), restockGoodsReq.getNumber());
    }

    //TODO: 한 번 팔 때 한 가지의 종류만 팔 수 있는 것으로 구현해야할 듯...
    @Transactional
    public List<BuyGoodsRes> sellGoods(BuyGoodsReq buyGoodsReq){
        Long userId = buyGoodsReq.getUserId();
        User user = userService.getUserOrThrow(userId);
        UserRole userRole = user.getUserRole();
        GoodsType goodsType = buyGoodsReq.getGoodsType();
        int numberToBuy = buyGoodsReq.getNumberToBuy();
        List<Goods> goodsList = goodsRepository.findAllByGoodsType(goodsType);

        if (userRole == UserRole.OFFICIAL) { //공직자
            int totalRemaining = goodsList.stream().mapToInt(Goods::getRemaining).sum();
            if (totalRemaining / 100f * 30 < numberToBuy)
                throw new IllegalArgumentException("30% 이상 구매 못해요");
        }else{ //나머지
            if (numberToBuy > 8)
                throw new IllegalArgumentException("9개 이상 구매 못해요");
        }

        //할인 로직
        double discountRate = 0;
        discountRate += userRole.getDiscountRate();


        //분배 로직
        List<Goods> sortedGoodsList = goodsList.stream().sorted(Comparator.comparingInt(Goods::getRemaining).reversed()).toList();
        List<Integer> diffs = new ArrayList<>(IntStream.rangeClosed(0, sortedGoodsList.size() - 2)
                .mapToObj(i -> (sortedGoodsList.get(i).getRemaining() - sortedGoodsList.get(i + 1).getRemaining())*(i+1))
                .toList());
        for (int i = 1; i < diffs.size(); i++) {
            diffs.set(i, diffs.get(i-1)+diffs.get(i));
        }

        int numberToDivide = 1;
        for (Integer diff : diffs) {
            if (diff < numberToBuy) numberToDivide++;
        }

        int criteria = (sortedGoodsList.size() > numberToDivide) ? sortedGoodsList.get(numberToDivide).getRemaining() : 0;
        int totalRemainingToDeduct = numberToBuy;
        List<BuyGoodsRes> buyGoodsResList = new ArrayList<>();
        for (int i = 0; i < numberToDivide - 1; i++) {
            Goods goodsToDeduct = sortedGoodsList.get(i);
            int numberToDeduct = Math.max(numberToBuy / numberToDivide, goodsToDeduct.getRemaining() - criteria);
            goodsToDeduct.deductRemaining(numberToDeduct);
            totalRemainingToDeduct -= numberToDeduct;
            buyGoodsResList.add(new BuyGoodsRes(goodsToDeduct.getId(), goodsToDeduct.getName(), numberToDeduct));
        }
        Goods lastGoodsToDeduct = sortedGoodsList.get(numberToDivide - 1);
        lastGoodsToDeduct.deductRemaining(totalRemainingToDeduct);
        buyGoodsResList.add(new BuyGoodsRes(lastGoodsToDeduct.getId(), lastGoodsToDeduct.getName(), totalRemainingToDeduct));

        //...
        //스티커 별 가격에 따라 총 금액 계산 로직
        //...
        //결제 로직
        //...
        //자산 추가 로직
        //...

        return buyGoodsResList;

    }

//---- 헬퍼 메서드

    @Transactional
    public void restockGoods(Goods goods, int numberToRestock){
        //필요한 돈
        int neededMoney = numberToRestock * 100;
        //할인 적용
        neededMoney -= (numberToRestock / 1000) * 25000;
        //금액 차감
        namwonCity.deductBalance(neededMoney);
        //재고 추가
        goods.addRemaining(numberToRestock);
    }

    @Transactional
    public void restockStickerByLevel(Sticker sticker){
        StickerLevel stickerLevel = sticker.getStickerLevel();
        restockGoods(sticker, stickerLevel.getAvailable());
    }

    @Transactional
    public void restockAllStickerByLevel(){
        List<Goods> stickerList = goodsRepository.findAllByGoodsType(GoodsType.STICKER);
        stickerList.forEach(goods -> restockStickerByLevel((Sticker) goods));
    }

    @Transactional(readOnly = true)
    public int getTheGoodsNumber(Long goodsId){
        return getGoodsOrThrow(goodsId).getRemaining();
    }

    @Transactional
    public List<GoodsInfoRes> getAllGoodsInfo(){
        //TODO: 굿즈 타입에 따라 다른 타입의 DTO
        return goodsRepository.findAll().stream()
                .map(goods -> new GoodsInfoRes(goods.getId(),goods.getName(), goods.getRemaining(), goods.getGoodsType()))
                .toList();
    }

    @Transactional(readOnly = true)
    public Goods getGoodsOrThrow(Long goodsId){
        return goodsRepository.findById(goodsId).orElseThrow(()->new IllegalArgumentException("그런 굿즈 없어요."));
    }

}
