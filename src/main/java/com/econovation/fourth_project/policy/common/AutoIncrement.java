package com.econovation.fourth_project.policy.common;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class AutoIncrement {
    private AtomicLong id = new AtomicLong(1);

    public Long autoIncrement() {
        return id.getAndIncrement();
    }
}
