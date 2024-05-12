package com.econovation.third_project.service;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.Registration;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final Database database;

    // 지원자 등록
    public void register(Registration registration){
        database.register(registration);
    }

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





    // 소속 학과 합

    // 지원 경로 통계

    // 면접 희망 시간

}
