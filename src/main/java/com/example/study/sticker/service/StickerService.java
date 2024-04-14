package com.example.study.sticker.service;

import com.example.study.discount.domain.DiscountService;
import com.example.study.member.domain.Member;
import com.example.study.member.domain.MemberType;
import com.example.study.member.service.MemberService;
import com.example.study.sticker.domain.Sticker;
import com.example.study.sticker.domain.Stickers;
import com.example.study.sticker.dto.AddStickerRequest;
import com.example.study.sticker.dto.BuyStickerRequest;
import com.example.study.sticker.dto.GetStickerRequest;
import com.example.study.sticker.repository.StickerRepository;
import lombok.RequiredArgsConstructor;
import lombok.Singular;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StickerService{

    private final StickerRepository stickerRepository;
    private final DiscountService discountService;
    private final MemberService memberService;

    public void add(AddStickerRequest addStickerRequest) {
        Sticker sticker = Sticker.createSticker(addStickerRequest.name(), addStickerRequest.count());
        stickerRepository.save(sticker);
    }

    public Long get(GetStickerRequest stickerRequest){
        Sticker sticker = stickerRepository.find(stickerRequest.name()).orElseThrow(NullPointerException::new);
        return sticker.getStock();
    }

    public void buy(BuyStickerRequest buyStickerRequest){
        Member member = memberService.find(buyStickerRequest.memberUUID());
        List<Sticker> stickers = stickerRepository.findAll();
        long allStocks = stickers.stream().mapToLong(Sticker::getStock).sum();
        checkBuyCount(member.getType(), buyStickerRequest.buyCount(), allStocks);

        Long price = discountService.execute(buyStickerRequest.buyCount(), member.getType()); //할인된 가격 구하기


        if(buyStickerRequest.price() > price){
            Stickers stickerList = Stickers.createStickers(stickers);



        }else{
            throw new IllegalArgumentException("돈이 부족합니다.");
        }

    }

    // 스티커 개수 확인
    private void checkBuyCount(MemberType memberType, Long buyCount, Long allStocks){
        if(buyCount > allStocks){
            throw new IllegalStateException("스티커 재고가 부족합니다.");
        }

        checkEachPersonBuyCount(buyCount);

        if(MemberType.isPublicOfficial(memberType)){
            checkPublicOfficialBuyCount(buyCount, allStocks);
        }
    }

    private void checkEachPersonBuyCount(Long buyCount) {
        if(buyCount > 8){
            throw new IllegalArgumentException("1명당 스티커를 총 8개 구매할 수 있습니다.");
        }
    }

    private void checkPublicOfficialBuyCount(Long buyCount, Long allStocks){
        if(buyCount > allStocks % 30){
            throw new IllegalArgumentException("공직자는 스티커의 총 재고 중 30%안에서만 구매 가능합니다.");
        }
    }


}
