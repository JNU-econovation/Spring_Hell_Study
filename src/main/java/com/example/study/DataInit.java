package com.example.study;

import com.example.study.city.domain.City;
import com.example.study.city.domain.Region;
import com.example.study.city.repository.CityRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final CityRepository cityRepository;
    @PostConstruct
    void init(){

        City city = City.builder()
                .name(Region.남원.name())
                .budget(1000000L)
                .build();
        cityRepository.save(city); // 시청 예산 세팅
    }

}
