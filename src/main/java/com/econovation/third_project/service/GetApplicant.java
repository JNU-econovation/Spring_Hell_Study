package com.econovation.third_project.service;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.Registration;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetApplicant {
    private final Database db;

    public ApplicantMapper getAllApplicant(){
        Map<String, Registration> allRegistration = db.getAllRegistration();

        // PG 개발자, PM 기획자, DE 디자이너
        // key = hopeField, value = 몇 명인지
        Map<String, Integer> allApplicantNum = new HashMap<>();

        allApplicantNum.put("PG", 0);
        allApplicantNum.put("PM", 0);
        allApplicantNum.put("DE", 0);

        // value = Registration
        for (String key : allRegistration.keySet()){
            Registration registration = allRegistration.get(key);
            allApplicantNum.put(registration.getHopeField(), allApplicantNum.get(registration.getHopeField()) + 1);
        }

        // WEB, APP, AI, GAME
        // key = firstPriority, secondPriority
        Map<String, int[]> allApplicantPriority = new HashMap<>();

        allApplicantPriority.put("WEB", new int[2]);
        allApplicantPriority.put("APP", new int[2]);
        allApplicantPriority.put("AI", new int[2]);
        allApplicantPriority.put("GAME", new int[2]);

        // value = Registration
        for (String key : allRegistration.keySet()){
            Registration registration = allRegistration.get(key);
            int[] firstPriority = allApplicantPriority.get(registration.getFirstPriority());
            int[] secondPriority = allApplicantPriority.get(registration.getSecondPriority());

            firstPriority[0] += 1;
            secondPriority[1] += 1;

        }

        return new ApplicantMapper(allApplicantNum, allApplicantPriority);
    }

//    public Map<String, int[]> getAllApplicantPriority(){
//        Map<String, Registration> allRegistration = db.getAllRegistration();
//        // WEB, APP, AI, GAME
//        Map<String, int[]> allApplicantPriority = new HashMap<>();
//
//        allApplicantPriority.put("WEB", new int[2]);
//        allApplicantPriority.put("APP", new int[2]);
//        allApplicantPriority.put("AI", new int[2]);
//        allApplicantPriority.put("GAME", new int[2]);
//
//        // value = Registration
//        for (String key : allRegistration.keySet()){
//            Registration registration = allRegistration.get(key);
//            int[] firstPriority = allApplicantPriority.get(registration.getFirstPriority());
//            int[] secondPriority = allApplicantPriority.get(registration.getSecondPriority());
//
//            firstPriority[0] += 1;
//            secondPriority[1] += 1;
//
//        }
//        return allApplicantPriority;
//    }
}
