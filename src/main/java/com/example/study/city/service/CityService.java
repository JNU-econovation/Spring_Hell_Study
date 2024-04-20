package com.example.study.city.service;

import com.example.study.city.domain.City;
import com.example.study.city.domain.Region;
import com.example.study.city.dto.FindStickersResponse;
import com.example.study.city.repository.CityRepository;
import com.example.study.printer.domain.Printer;
import com.example.study.city.dto.BuyStickerRequest;
import com.example.study.sticker.service.StickerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final Printer printer;
    private final StickerService stickerService;
    public void buy(BuyStickerRequest buyStickerRequest) {

        // 스티커 가격 조회
        long allStickerCount = buyStickerRequest.buyStickerDTOS().stream().mapToLong(dto -> dto.count()).sum();
        Long stickerPrice = printer.getStickerPrice(allStickerCount);

        // 시청 예산 확인
        Long cityBudget = cityRepository.findCityBudget(Region.남원.name());

        // 스티커 구매
        if(cityBudget >= stickerPrice){
            City city = cityRepository.find(Region.남원.name());
            List<String> stickerNames = stickerService.add(city.getStickerNames(), buyStickerRequest.buyStickerDTOS());
            cityRepository.save(city.updateBudget(stickerPrice, stickerNames));
        }

    }

    public List<String> findStickers(String name){
        City city = cityRepository.find(name);
        List<String> stickerNames = city.getStickerNames();
        return stickerNames;
    }
}
