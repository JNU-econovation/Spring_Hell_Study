package com.example.study.sticker.service;

import com.example.study.city.dto.FindStickersResponse;
import com.example.study.city.dto.StickerDTO;
import com.example.study.discount.domain.DiscountService;
import com.example.study.member.domain.Member;
import com.example.study.member.domain.MemberType;
import com.example.study.member.service.MemberService;
import com.example.study.sticker.domain.Sticker;
import com.example.study.sticker.domain.Stickers;
import com.example.study.sticker.dto.BuyStickerRequest;
import com.example.study.sticker.repository.StickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StickerService{

    private final StickerRepository stickerRepository;
    private final DiscountService discountService;
    private final MemberService memberService;

    public List<String> add(List<String> stickerNames, List<StickerDTO> stickerDTOS) {

        List<String> newStickerNames = new ArrayList<>(stickerNames);

        for(StickerDTO stickerDTO : stickerDTOS) {
            if(stickerNames.contains(stickerDTO.name())){
                Sticker sticker = stickerRepository.find(stickerDTO.name()).orElseThrow(NullPointerException::new);
                Sticker updatedSticker = sticker.plusStock(stickerDTO.count());
                stickerRepository.save(updatedSticker);
            }else{
                Sticker sticker = Sticker.createSticker(stickerDTO.name(), stickerDTO.count());
                stickerRepository.save(sticker);
                newStickerNames.add(stickerDTO.name());
            }
        }

        return newStickerNames;
    }

    public FindStickersResponse findAll(List<String> stickerNames){
        List<Sticker> stickers = stickerRepository.findAll(stickerNames);
        List<StickerDTO> stickerDTOS = stickers.stream()
                .map(sticker -> new StickerDTO(sticker.getName(), sticker.getStock()))
                .collect(Collectors.toList());
        return new FindStickersResponse(stickerDTOS);
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
