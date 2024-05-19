package com.econovation.third_project.service;

import com.econovation.third_project.database.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final Database database;

    // 지원자 등록
    public void register(Registration registration){
        database.register(registration);
    }

    // 개인 정보 등록
    public void registerPersonalInform(PersonalInformation personalInformation){database.savePersonalInformation(personalInformation);}

    // 지원 경로 정보 등록
    public void registerPath(Path path){database.savePath(path);}

    // 면접 가능 시간 등록
    public void registerDesiredTime(DesiredTime desiredTime){database.saveDesiredTime(desiredTime);}

    // 전체 지원자 수 누적 합
    public int getRegistrationCount(){
        return database.getRegistrationCount();
    }

    // 각 분야별 합
    // database의 registration을 조회, 조회하면서 getRegistration을 통해 Registration을 가져옴
    // 들어있는 분야 별로 Count하기 (개발자, 기획자, 디자이너)
    public ArrayList<Integer> getHopeFieldsTotalCount(){
        return database.getHopeFieldsTotalCount();
    }

    // 희망 분야별 합
    // 등록시 1지망 2지망을 나눠서 토탈 카운트
    // 희망 분야별 합은 service 파일에서 작성
    public Map<String, Integer> getHopeFieldsFirstPriorityCount() {
        Map<String, Integer> firstHopeFieldCount = new HashMap<>();
        for (Registration registration : database.getAllRegistrations().values()) {
            String firstHopeField = registration.getFirstPriority();
            firstHopeFieldCount.put(firstHopeField, firstHopeFieldCount.getOrDefault(firstHopeField, 0) + 1); // getOrDefault
        }
        return firstHopeFieldCount;
    }

    public Map<String, Integer> getHopeFieldsSecondPriorityCount() {
        Map<String, Integer> secondHopeFieldCount = new HashMap<>();
        for (Registration registration : database.getAllRegistrations().values()) {
            String secondHopeField = registration.getSecondPriority();
            secondHopeFieldCount.put(secondHopeField, secondHopeFieldCount.getOrDefault(secondHopeField, 0) + 1);
        }
        return secondHopeFieldCount;
    }

    // 소속 학과 합
    public Map<String,Integer> getDepartmentCount(){
        Map<String,Integer> departmentCount = new HashMap<>();
        for(PersonalInformation personalInformation : database.getAllPersionalInformation().values()){
            String major = personalInformation.getMajor();
            departmentCount.put(major, departmentCount.getOrDefault(major,0)+1);
        }
        return departmentCount;
    }

    // 지원 경로 통계
    public Map<String,Integer> getPathCount(){
        Map<String,Integer> pathCount = new HashMap<>();
        for(Path path : database.getAllPath().values()){
            String p = path.getSupportPath().getType();
            pathCount.put(p,pathCount.getOrDefault(p,0)+1);
        }
        return pathCount;
    }

    // 면접 희망 시간

}
