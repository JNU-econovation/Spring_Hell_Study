package com.econovation.springstudy.service;

import com.econovation.springstudy.dto.goods.BuyGoodsReq;
import com.econovation.springstudy.dto.goods.CreateGoodsReq;
import com.econovation.springstudy.entity.Goods;
import com.econovation.springstudy.repository.GoodsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GoodsService {
    private final GoodsRepository goodsRepository;

    public GoodsService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Transactional
    public void createGoods(CreateGoodsReq createGoodsReq){
        Goods goods = createGoodsReq.toEntity();
        goodsRepository.save(goods);
    }

    @Transactional
    public void buyGoods(BuyGoodsReq buyGoodsReq){

        //구매한 스티커 고려해서 할인 적용해서 총 금액 계산
        //금액 확인하고 차감
        //스티커 재고 추가
        //구매한 스티커 개수 올리기
    }

    @Transactional
    public void sellGoods(){
        //공직자 고려해서 금액 계산
        //금액 가지고 있는지 확인
        //각 스티커마다 개수 가져오기
        //개수대로 정렬하고, 주문한 개수만큼 하나씩 빼기
            //이때 특정 스티커의 수량이 없을경우 있는거에서 빼기
        //구매한 스티커 개수 올리기
        //금액 차감
    }

    @Transactional(readOnly = true)
    public int getTheStickerNumber(Long stickerId){
        Goods goods = goodsRepository.findById(stickerId).orElseThrow(()->new IllegalArgumentException("그런 스티커 없어요."));
        return goods.getRemaining();
    }




}
