package com.econovation.third_project.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

@Getter
public class DesiredTime {
    private static final Map<List<Integer>, List<Integer>> cachedTimes = new HashMap<>();
    private final List<List<Integer>> desiredTimes;

    public DesiredTime(List<List<Integer>> desiredTimes) {
        validateDesiredTime(desiredTimes);
        this.desiredTimes = desiredTimes.stream()
                .map(time-> cachedTimes.computeIfAbsent(time, t->t))
                .toList();
    }
    private void validateDesiredTime(List<List<Integer>> desiredTimes) {
        //27기 기준
        int interviewDays = 3;
        int hoursPerDay = 11;

        desiredTimes.forEach(
                time -> {
                    if (time.get(0) >= interviewDays || time.get(1) >= hoursPerDay)
                        throw new IllegalArgumentException("면접 시간 잘못 입력");
                }
        );

    }
}
