package com.econovation.third_project.controller;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.Registration;
import com.econovation.third_project.dto.ApplicantNumberByJobRes;
import com.econovation.third_project.service.RegistrationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class AdminQueryController {
    private final Database database;
    private final RegistrationService registrationService;

    // 예시 코드
    @PostMapping("/registration")
    public ResponseEntity<Object> postRegistration(@RequestBody Registration registration) {
        database.register(registration);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/registration")
    public ResponseEntity<Registration> getRegistration(String userId) {
        return ResponseEntity.ok().body(database.getRegistration(userId));
    }

    //아래 두 개 묶기
    @GetMapping("/registration/numbers/job") //uri 다시.. 확장성: 다른 필터링을 적용할 수 있다고 생각
    public ResponseEntity<List<ApplicantNumberByJobRes>> getApplicationNumbersByJob(){
        return ResponseEntity.ok().body(registrationService.getApplicantNumbersByJob());
    }

    @GetMapping("/registration/numbers/job-field")
    public ResponseEntity<List<ApplicantNumberByJobRes>> getApplicationNumbersByJobFieldAndPriority(){
        return ResponseEntity.ok().body(registrationService.getApplicantNumbersByJobFieldAndPriority();
    }




}
