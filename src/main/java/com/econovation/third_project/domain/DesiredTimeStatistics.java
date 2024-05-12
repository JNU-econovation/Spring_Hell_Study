package com.econovation.third_project.domain;

import com.econovation.third_project.database.DesiredTime;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@NoArgsConstructor
public class DesiredTimeStatistics {

    // [1,2] - 김종민 이렇게 저장된다.
    private final Map<List<Integer>, List<String>> cnt = new HashMap<>();

    public void put(List<Integer> key, String value){
        if(cnt.containsKey(key)) cnt.get(key).add(value);
        cnt.put(key, Arrays.asList(value));
    }

    public static DesiredTimeStatistics of(List<DesiredTime> desiredTimes){
        desiredTimes.stream()
                .peek(
                        times -> {
                            List<int[]> desiredTime = times.getDesiredTime();
                            for (int i = 0; i < 3; i++) {
                                List<Integer> tmp = new ArrayList<>();
                                int[] targetArr = desiredTime.get(i);
                                for (int j = 0; j < desiredTime.size(); i++) {
                                    if (targetArr[j] == 1) tmp.add(j);
                                }
                                DesiredTimeStatistics.put(tmp,times.getRegistrationId());
                            }
                        }
                );

        return new DesiredTimeStatistics();
    }
}
