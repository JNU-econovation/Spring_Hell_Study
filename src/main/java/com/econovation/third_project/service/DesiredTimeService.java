package com.econovation.third_project.service;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.dto.ApplicantNumberInJob;
import com.econovation.third_project.dto.ApplicantNumberInTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DesiredTimeService {
    private final Database db;

    //입력할 때 2개인지 확인해야 함

    public List<ApplicantNumberInTime> getApplicantNumberEachTime(){
        return db.getAllDesiredTime().stream()
                .flatMap(desiredTime -> desiredTime.getDesiredTimes().stream())
                .collect(Collectors.groupingBy(time -> time, Collectors.counting()))
                .entrySet().stream()
                .map(entry->new ApplicantNumberInTime(entry.getKey(), entry.getValue().intValue()))
                .toList();
    }

}
