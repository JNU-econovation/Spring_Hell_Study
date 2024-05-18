package com.econovation.third_project.database;

import java.util.List;

public final class DesiredTimeNow extends DesiredTime{
    public DesiredTimeNow(String registrationId, List<List<Integer>> desiredTimes){
        super(registrationId, desiredTimes);
    }

    @Override
    void validateDesiredTime(List<List<Integer>> desiredTimes) {
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
