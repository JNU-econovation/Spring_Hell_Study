package com.example.study.city.repository;

import com.example.study.city.domain.City;
import org.springframework.stereotype.Repository;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CityMemoryRepository implements CityRepository{

    private final ConcurrentHashMap<String, City> cityConcurrentHashMap = new ConcurrentHashMap<>();
    @Override
    public void save(City city) {
        cityConcurrentHashMap.put(city.getName(), city);
    }

    @Override
    public Long findCityBudget(String name) {
        return cityConcurrentHashMap.get(name).getBudget();
        //todo 시청이 없을 때 고려
    }

    @Override
    public City find(String name) {
        return cityConcurrentHashMap.get(name);
    }
}
