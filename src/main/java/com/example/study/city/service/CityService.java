package com.example.study.city.service;

import com.example.study.city.domain.City;
import com.example.study.city.domain.Region;
import com.example.study.city.repository.CityRepository;
import com.example.study.printer.domain.Printer;
import com.example.study.city.dto.BuyStickerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final Printer printer;
    public void buy(BuyStickerRequest buyStickerRequest) {

        // 스티커 가격 조회
        long allStickerCount = buyStickerRequest.buyStickerDTOS().stream().mapToLong(dto -> dto.count()).sum();
        Long stickerPrice = printer.getStickerPrice(allStickerCount);

        // 시청 예산 확인
        Long cityBudget = cityRepository.findCityBudget(Region.남원.name());

        // 스티커 구매
        if(cityBudget >= stickerPrice){
            City city = cityRepository.find(Region.남원.name());
            cityRepository.save(city.updateBudget(stickerPrice));
        }


    }
}
