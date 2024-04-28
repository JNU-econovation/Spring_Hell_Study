package com.econovation.hellstudy.common.helper;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicUtils {

    // dataBase의 Auto-Increment
    public static long autoIncrement(AtomicLong counter) {
        long value = counter.get();
        long newValue = value + 1;
        counter.set(newValue);
        return newValue;
    }
}
