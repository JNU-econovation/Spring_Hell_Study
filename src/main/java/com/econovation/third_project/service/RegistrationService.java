package com.econovation.third_project.service;


import com.econovation.third_project.database.Database;
import com.econovation.third_project.config.Field;
import com.econovation.third_project.config.Job;
import com.econovation.third_project.database.Registration;
import com.econovation.third_project.dto.ApplicantNumberInJob;
import com.econovation.third_project.dto.ApplicantNumberInField;
import static java.util.Comparator.reverseOrder;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;




@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final Database db;

    //분야별 지원자 수
    public List<ApplicantNumberInJob> getApplicantNumbersEachJob(){
        return db.getAllRegistrations().stream()
                .collect(Collectors.groupingBy(Registration::getHopeJob, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Job, Long>comparingByValue().reversed())
                .map(entry->new ApplicantNumberInJob(entry.getKey().getJobName(), entry.getValue().intValue()))
                .toList();
    }

    //지원 조회
    public Registration getRegistration(String registrationId){
        return db.getRegistration(registrationId);
    }

    //세부 분야별 지원자 수
    public List<ApplicantNumberInField> getApplicantNumberEachField(){
        Map<Field, int[]> jobPriorityCounts = new EnumMap<>(Field.class);

        for (Field field : Field.values())
            jobPriorityCounts.put(field, new int[2]);

        db.getAllRegistrations()
                .forEach(regi->{
                    jobPriorityCounts.get(regi.getFirstPriority())[0]++;
                    regi.getSecondPriority()
                            .ifPresent(secondPriority -> jobPriorityCounts.get(secondPriority)[1]++);
                });

        return jobPriorityCounts.entrySet()
                .stream()
                .map(entry->
                        new ApplicantNumberInField(
                                entry.getKey().getFieldName(),
                                entry.getValue()[0],
                                entry.getValue()[1]))
                .sorted(reverseOrder())
                .toList();
    }

    //지원 등록
//    public PostRegistrationRes postRegistration()

    //지원 수정

    //지원 삭제

}
