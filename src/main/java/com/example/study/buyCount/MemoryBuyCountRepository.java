package com.example.study.buyCount;

import org.springframework.stereotype.Repository;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemoryBuyCountRepository implements BuyCountRepository{

    private final AtomicLong buyCountToOfficial = new AtomicLong(0L);
    @Override
    public Long find() {
        return buyCountToOfficial.get();
    }

    @Override
    public void increment(Long count) {
        buyCountToOfficial.accumulateAndGet(count, (currentValue, incrementValue) -> currentValue + incrementValue);
    }


}
