package com.econovation.hellstudy.common.helper;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicUtils {

    // dataBase의 Auto-Increment
    public static int autoIncrement(AtomicInteger counter) {
        int value = counter.get();
        int newValue = value + 1;
        counter.set(newValue);
        return newValue;
    }
}
