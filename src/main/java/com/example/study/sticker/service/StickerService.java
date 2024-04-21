package com.example.study.sticker.service;

import com.example.study.buyCount.MemoryBuyCountRepository;
import com.example.study.city.dto.AddStickerRequest;
import com.example.study.city.dto.FindStickersResponse;
import com.example.study.city.dto.StickerDTO;
import com.example.study.city.service.CityService;
import com.example.study.member.domain.Member;
import com.example.study.member.domain.MemberType;
import com.example.study.member.service.MemberService;
import com.example.study.sticker.domain.Sticker;
import com.example.study.sticker.dto.SellStickerRequest;
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
    private final CityService cityService;
    private final MemberService memberService;
    private final MemoryBuyCountRepository memoryBuyCountRepository;

    public void add(String cityName, AddStickerRequest addStickerRequest) {
        cityService.pay(cityName, addStickerRequest);

        List<String> stickerNames = cityService.findStickers(cityName);

        List<String> newStickerNames = new ArrayList<>(stickerNames);

        for(StickerDTO stickerDTO : addStickerRequest.stickerDTOs()) {
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

        cityService.updateCityStickers(cityName, newStickerNames);
    }

    public FindStickersResponse findStickerStocks(String cityName){
        List<String> stickerNames = cityService.findStickers(cityName);
        List<Sticker> stickers = stickerRepository.findAll(stickerNames);
        List<StickerDTO> stickerDTOS = stickers.stream()
                .map(sticker -> new StickerDTO(sticker.getName(), sticker.getStock()))
                .collect(Collectors.toList());
        return new FindStickersResponse(stickerDTOS);
    }

    public void sell(String cityName, SellStickerRequest sellStickerRequest){

        // 인당 8개 재고 제한
        Member member = memberService.find(sellStickerRequest.memberName());
        Long buyCount = member.getBuyCount();
        if(buyCount + sellStickerRequest.count() >= 8){
            throw new IllegalArgumentException("스티커는 인당 8개를 구매할 수 있습니다.");
        }









    }





}
