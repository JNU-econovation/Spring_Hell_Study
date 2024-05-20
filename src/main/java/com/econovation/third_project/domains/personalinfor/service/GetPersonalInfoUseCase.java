package com.econovation.third_project.domains.personalinfor.service;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.PersonalInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class GetPersonalInfoUseCase {
    private final Database database;

    /**
     * 소속 학과 합계
     */
    public Map<String, Long> execute() {
        return database.findAllPersonalInformation().stream().collect(
                groupingBy(PersonalInformation::getMajor, Collectors.counting())
        );
    }
}
