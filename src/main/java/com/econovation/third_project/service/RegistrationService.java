package com.econovation.third_project.service;


import com.econovation.third_project.database.Database;
import com.econovation.third_project.config.Field;
import com.econovation.third_project.config.Job;
import com.econovation.third_project.database.Registration;
import com.econovation.third_project.dto.ApplicantNumberInJob;
import com.econovation.third_project.dto.ApplicantNumberInField;
import static java.util.Comparator.reverseOrder;

import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Getter;
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

    //세부 분야별 지원자 수
    public List<ApplicantNumberInField> getApplicantNumberEachField(){
        return PriorityCounts.of(db.getAllRegistrations())
                .getJobPriorityCounts()
                .entrySet().stream()
                .map(ApplicantNumberInField::new)
                .sorted(reverseOrder())
                .toList();
    }

}

@Getter
final class PriorityCounts{
    private final Map<Field, int[]> jobPriorityCounts = new EnumMap<>(Field.class);

    private PriorityCounts() {
        for (Field field : Field.values())
            jobPriorityCounts.put(field, new int[2]);
    }
    static PriorityCounts of(Collection<Registration> registrations){
        PriorityCounts priorityCounts = new PriorityCounts();
        registrations.forEach(regi->{
                    priorityCounts.incrementFirstPriority(regi.getFirstPriority());
                    priorityCounts.incrementSecondPriority(regi.getSecondPriority());
                });
        return priorityCounts;
    }

    private void incrementFirstPriority(Field field){
        jobPriorityCounts.get(field)[0]++;
    }
    private void incrementSecondPriority(Field field){
        jobPriorityCounts.get(field)[1]++;
    }
}
