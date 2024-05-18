package com.econovation.third_project.service;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.dto.ApplicantNumberInMajor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonalInformationService {
    private final Database db;

    //학과별 지원자 수
    public List<ApplicantNumberInMajor> getApplicantNumberEachMajor(){
        Map<String, Integer> majorCounts = new HashMap<>();

        db.getAllPersonalInformation().forEach(info -> {
            //주전공
            majorCounts.merge(info.getMajor(), 1, Integer::sum);
            //복수전공
            info.getDoubleMajor().ifPresent(doubleMajor -> majorCounts.merge(doubleMajor, 1, Integer::sum));
        });

        return majorCounts.entrySet().stream()
                .map(entry -> new ApplicantNumberInMajor(entry.getKey(), entry.getValue()))
                .toList();
    }
}