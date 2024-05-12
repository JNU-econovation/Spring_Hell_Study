package com.econovation.third_project.service;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.Path;
import com.econovation.third_project.database.Registration;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPath {
    private final Database db;

    public Map<String, Integer> getAllApplicantNum(){
        Map<String, Path> allPath = db.getAllPath();
        // 홍보 포스터, 학과 공지사항, 지인 소개, 인스타그램, 에브리타임
        // key = supportPath, value = 몇 명인지
        Map<String, Integer> allSupportPath = new HashMap<>();
        allSupportPath.put("홍보 포스터", 0);
        allSupportPath.put("학과 공지사항", 0);
        allSupportPath.put("지인 소개", 0);
        allSupportPath.put("지인 인스타그램", 0);
        allSupportPath.put("에브리타임", 0);

        for (String key : allPath.keySet()){
            Path path = allPath.get(key);
            allSupportPath.put(path.getSupportPath(), allSupportPath.get(path.getSupportPath()) + 1);
        }
        return allSupportPath;
    }
}
