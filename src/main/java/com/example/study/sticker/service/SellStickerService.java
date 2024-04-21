package com.example.study.sticker.service;

import com.example.study.buyCount.MemoryBuyCountRepository;
import com.example.study.city.service.CityService;
import com.example.study.member.domain.Member;
import com.example.study.member.domain.MemberType;
import com.example.study.member.service.MemberService;
import com.example.study.sticker.domain.Sticker;
import com.example.study.sticker.dto.SellStickerRequest;
import com.example.study.sticker.repository.StickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SellStickerService {

    private final MemberService memberService;
    private final MemoryBuyCountRepository memoryBuyCountRepository;
    private final StickerRepository stickerRepository;
    private final CityService cityService;

    public void execute(String cityName, SellStickerRequest sellStickerRequest){

        // 인당 8개 재고 제한
        Member member = memberService.find(sellStickerRequest.memberName());
        Long buyCount = member.getBuyCount();
        if(buyCount + sellStickerRequest.count() >= 8){
            throw new IllegalArgumentException("스티커는 인당 8개를 구매할 수 있습니다.");
        }


        List<String> stickerNames = cityService.findStickers(cityName);
        List<Sticker> stickers = stickerRepository.findAll(stickerNames);
        long allStickerStocks = stickers.stream().mapToLong(s -> s.getStock()).sum();

        // 스티커의 총 재고가 사용자가 사려는 개수보다 미만인 경우
        if(allStickerStocks < sellStickerRequest.count()){
            throw new IllegalStateException("스티커의 재고가 부족합니다.");
        }


        // 공직자에게 제공할 수 있는 모든 판매 갯수는 전체 갯수의 30%로 제한
        long maxOfficialBuyCount = (long) (allStickerStocks * 0.3);

        Long originalPrice = Sticker.PRICE * sellStickerRequest.count();

        if(MemberType.isPublicOfficial(member.getType())){
            Long officialBuyCount = memoryBuyCountRepository.find();
            if(officialBuyCount > maxOfficialBuyCount){
                throw new IllegalStateException("공직자에게 제공할 수 있는 모든 판매 갯수는 전체 갯수의 30%까지입니다.");
            }
            // 공직자의 판매 갯수 증가
            memoryBuyCountRepository.increment(sellStickerRequest.count());

            // 공직자일 시 10% 할인 판매
            long discountPrice = Math.subtractExact(originalPrice, originalPrice / 10);
            if(sellStickerRequest.money() < discountPrice){
                throw new IllegalArgumentException("돈이 부족합니다.");
            }
        }


        // 일반일 시 그냥 판매
        if(sellStickerRequest.money() < originalPrice){
            throw new IllegalArgumentException("돈이 부족합니다.");
        }

        // 스티커 랜덤 선택후 재고 반영
        Map<String, Long> stickerAllocation = randomAllocate(stickers, buyCount);
        for (Sticker sticker : stickers) {
            long toBuy = stickerAllocation.get(sticker.getName());
            Sticker minusStock = sticker.minusStock(sticker.getStock() - toBuy);
            stickerRepository.save(minusStock); // 재고 업데이트
        }


    }

    private Map<String, Long> randomAllocate(List<Sticker> stickers, long buyCount) {

        Map<String, Long> allocation = new HashMap<>();
        long totalStickers = stickers.size();

        // 초기 분배 갯수 설정
        long baseCount = buyCount / totalStickers;
        long remainingCount = buyCount % totalStickers;

        // 기본 할당 수량 설정
        for (Sticker sticker : stickers) {
            long count = Math.min(sticker.getStock(), baseCount); // 재고를 초과하지 않는 선에서 기본 수량 할당
            allocation.put(sticker.getName(), count);
            remainingCount += baseCount - count; // 할당하지 못한 수량 재계산
        }

        // 남은 수량 할당
        while (remainingCount > 0) {
            for (Sticker sticker : stickers) {
                if (remainingCount == 0) break;
                if (sticker.getStock() > allocation.get(sticker.getName())) { // 재고가 할당량보다 많은 경우
                    allocation.put(sticker.getName(), allocation.get(sticker.getName()) + 1);
                    remainingCount--;
                }
            }
        }
        return allocation;
    }
}
