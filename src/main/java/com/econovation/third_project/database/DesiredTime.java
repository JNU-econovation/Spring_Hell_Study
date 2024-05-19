package com.econovation.third_project.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

@Getter
public abstract class DesiredTime {
    private static final Map<List<Integer>, List<Integer>> cachedTimes = new HashMap<>();

    // 희망 시간 (11 * 3)의 테이블 형태를 준수합니다.
    final List<List<Integer>> desiredTimes;

    abstract void validateDesiredTime(List<List<Integer>> desiredTimes);

    DesiredTime(List<List<Integer>> desiredTimes) {
        validateDesiredTime(desiredTimes);
        this.desiredTimes = desiredTimes.stream()
                .map(time-> cachedTimes.computeIfAbsent(time, t->t))
                .toList();
    }
}
