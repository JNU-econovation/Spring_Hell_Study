package com.econovation.third_project.controller;

import com.econovation.third_project.agrregate.AdminPageQueryAggregator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminQueryController {
    private final AdminPageQueryAggregator adminPageQueryAggregator;

    @GetMapping("/applicants/async-test")
    public ResponseEntity<Map<String, List<?>>> getApplicantsInfo(@RequestBody Set<String> fields){
        return ResponseEntity.ok().body(
                adminPageQueryAggregator.aggregate(fields));
    }


    //TODO:
    // 병렬 스트림 + async의 장점,
    // 병렬 스트림, async 각각 적절한 상황,
    // 서비스 메서드마다 다른 인자가 필요한 경우,
    // 일부 의존 관계가 있을경우 어떻게 처리할지
    // 서비스 메서드 맵 어떻게 뺄지,
    // 적절한 스레드 수 알아보기,
    // 자바 비동기 기초,

}
