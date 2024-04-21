package com.example.study.buyCount;


import org.springframework.stereotype.Component;

@Component
public interface BuyCountRepository {
    Long find();
    void increment(Long count);
}
