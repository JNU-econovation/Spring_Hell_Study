package com.econovation.third_project.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javax.persistence.criteria.CriteriaBuilder.In;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public abstract class DesiredTime {
    private static final Map<List<Integer>, List<Integer>> cachedTimes = new HashMap<>();

    String registrationId;
    // 희망 시간 (11 * 3)의 테이블 형태를 준수합니다.
    final List<List<Integer>> desiredTimes;

    abstract void validateDesiredTime(List<List<Integer>> desiredTimes);

    DesiredTime(String registrationId, List<List<Integer>> desiredTimes) {
        validateDesiredTime(desiredTimes);
        this.registrationId = registrationId;
        this.desiredTimes = desiredTimes.stream()
                .map(time-> cachedTimes.putIfAbsent(time, time))
                .toList();
    }
}
