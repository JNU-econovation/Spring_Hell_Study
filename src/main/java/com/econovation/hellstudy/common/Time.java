package com.econovation.hellstudy.common;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Time {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Time() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void updateTime(){
        this.updatedAt = LocalDateTime.now();
    }


}
