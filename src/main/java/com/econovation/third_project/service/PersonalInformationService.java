package com.econovation.third_project.service;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.dto.ApplicantNumberInMajor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonalInformationService {
    private final Database db;

    //학과별 지원자 수
    public List<ApplicantNumberInMajor> getApplicantNumberEachMajor(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return db.getAllPersonalInformation().stream()
                .flatMap(info-> Stream.of(info.getMajor(), info.getDoubleMajor().orElse(null)))
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(entry-> new ApplicantNumberInMajor(entry.getKey(), entry.getValue().intValue()))
                .toList();
    }
}