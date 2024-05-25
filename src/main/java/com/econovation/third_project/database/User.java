package com.econovation.third_project.database;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private static final AtomicInteger lastUsedId = new AtomicInteger(0);

    private static int nextId(){
        return lastUsedId.getAndIncrement();
    }

}
