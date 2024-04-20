package com.example.study.city.service;

import com.example.study.city.domain.City;
import com.example.study.city.repository.CityRepository;
import com.example.study.printer.domain.Printer;
import com.example.study.city.dto.AddStickerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final Printer printer;
    public void pay(String cityName, AddStickerRequest addStickerRequest) {

        // 스티커 가격 조회
        long allStickerCount = addStickerRequest.stickerDTOs().stream().mapToLong(dto -> dto.count()).sum();
        Long stickerPrice = printer.getStickerPrice(allStickerCount);

        // 시청 예산 확인
        City city = cityRepository.find(cityName);
        Long cityBudget = city.getBudget();

        // 스티커 구매
        if(cityBudget < stickerPrice){
            throw new IllegalArgumentException("예산이 부족합니다");
        }

        cityRepository.save(city.updateBudget(stickerPrice));
    }

    // 시청 스티커이름 저장
    public void updateCityStickers(String cityName, List<String> stickerNames){
        City city = cityRepository.find(cityName);
        cityRepository.save(city.updateStickerNames(stickerNames));
    }


    public List<String> findStickers(String name){
        City city = cityRepository.find(name);
        List<String> stickerNames = city.getStickerNames();
        return stickerNames;
    }
}
