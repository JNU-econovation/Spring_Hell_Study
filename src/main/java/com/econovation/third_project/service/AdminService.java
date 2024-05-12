package com.econovation.third_project.service;

import com.econovation.third_project.database.*;
import com.econovation.third_project.domain.AllApplicantCnt;
import com.econovation.third_project.domain.AllApplicantStatistics;
import com.econovation.third_project.domain.ApplyPathCnt;
import com.econovation.third_project.domain.DesiredTimeStatistics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final Database database;

    public AllApplicantStatistics getAllStatistics(){

        return AllApplicantStatistics.builder()
                .cnt(getAllRegistration().size())
                .hopeFieldCnt(toHopeFieldCnt(getAllRegistration()))
                .majorCnt(toMajorcnt(getAllPersonalInformation()))
                .pathCnt(toPathCnt(getAllPath()))
                .desiredTimes(toDesiredTimeStatistics(getAllDesiredTimes()))
                .build();
    }

    private Map<String, Integer> toHopeFieldCnt(List<Registration> registrations){
        Map<String, Integer> hopeFieldCnt = new HashMap<>();

        return registrations.stream()
                .map(registration -> registration.getHopeField())
                .collect(Collectors.groupingBy(
                        s -> s, // 키는 희망 분야 그대로
                        Collectors.mapping(
                                s -> 1, // 희망 분야를 1로 변경
                                Collectors.reducing(0, (i,j)->i+j) // 누적
                        )
                ));

    }

    // 주전공만 카운트
    // 복수전공까지 카운트 해야 한다.
    private Map<String, Integer> toMajorcnt(List<PersonalInformation> personalInformations){
        return personalInformations.stream()
                .map(personalInformation -> personalInformation.getMajor())
                .collect(Collectors.groupingBy(
                        s -> s,
                        Collectors.mapping(
                                s -> 1,
                                Collectors.reducing(0, (i,j)->i+j))
                    )
                );
    }


    private Map<String, Integer> toPathCnt(List<Path> paths){
        return paths.stream()
                .map(path -> path.getSupportPath())
                .collect(Collectors.groupingBy(
                        s -> s,
                        Collectors.mapping(
                                s -> 1,
                                Collectors.reducing(0, (i,j)->i+j)
                        )
                ));
    }

    private DesiredTimeStatistics toDesiredTimeStatistics(List<DesiredTime> desiredTimes){
        
    }

    private List<Registration> getAllRegistration(){ return database.getRegistrations(); }

    private List<Path> getAllPath(){ return database.getPaths(); }

    private List<PersonalInformation> getAllPersonalInformation(){ return database.getPersonalInformations(); }

    private List<DesiredTime> getAllDesiredTimes(){ return database.getDesiredTimes(); }

}