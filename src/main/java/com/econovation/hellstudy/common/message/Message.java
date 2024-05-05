package com.econovation.hellstudy.common.message;

import lombok.Getter;

import java.util.List;
@Getter
public class Message {
     private Integer failCount;
     private List<Exception> exceptions;
     private Integer failLimit;

    public void increaseFailCount() {
        failCount++;
    }

    public boolean isFailLimitExceeded() {
        return failCount >= failLimit;
    }

    public void addException(Exception e) {
        exceptions.add(e);
    }
}
