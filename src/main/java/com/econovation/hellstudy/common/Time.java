package com.econovation.hellstudy.common;

import lombok.Getter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
public class Time {

    private LocalDateTime createdAt;

    public Time(long time) {
        this.createdAt = LocalDateTime.ofInstant(Instant.ofEpochSecond(time), ZoneId.of("Asia/Seoul"));
    }

}
