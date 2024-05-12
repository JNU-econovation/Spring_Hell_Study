package com.econovation.third_project.service;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.PersonalInformation;
import com.econovation.third_project.database.Registration;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMajor {
    private final Database db;

    public Map<String, Integer> getAllMajor(){
        Map<String, PersonalInformation> allPersonalInformation = db.getAllPersonalInformation();
        // PG 개발자, PM 기획자, DE 디자이너
        // key = hopeField, value = 몇 명인지
        Map<String, Integer> allMajor = new HashMap<>();


        for (String key : allPersonalInformation.keySet()){
            PersonalInformation personalInformation = allPersonalInformation.get(key);

            String major = personalInformation.getMajor();
            String doubleMajor = personalInformation.getDoubleMajor();
            String minor = personalInformation.getMinor();

            // 리팩토링 예정
            if(!allMajor.containsKey(major)){
                allMajor.put(major, 0);
            }
            if(!allMajor.containsKey(doubleMajor)){
                allMajor.put(doubleMajor, 0);
            }
            if(!allMajor.containsKey(minor)){
                allMajor.put(minor, 0);
            }

            allMajor.put(major, allMajor.get(major) + 1);
            allMajor.put(doubleMajor, allMajor.get(doubleMajor) + 1);
            allMajor.put(minor, allMajor.get(minor) + 1);
        }
        return allMajor;
    }
}
