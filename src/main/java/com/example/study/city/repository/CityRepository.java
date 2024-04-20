package com.example.study.city.repository;

import com.example.study.city.domain.City;
import org.springframework.stereotype.Component;

@Component
public interface CityRepository {

    void save(City city);

    Long findCityBudget(String name);

    City find(String name);
}
