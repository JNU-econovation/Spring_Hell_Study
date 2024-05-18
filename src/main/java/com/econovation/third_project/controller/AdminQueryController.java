package com.econovation.third_project.controller;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.Registration;
import com.econovation.third_project.service.DesiredTimeService;
import com.econovation.third_project.service.PathService;
import com.econovation.third_project.service.PersonalInformationService;
import com.econovation.third_project.service.RegistrationService;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminQueryController {
    private final Database database;
    private final RegistrationService registrationService;
    private final PathService pathService;
    private final PersonalInformationService personalInformationService;
    private final DesiredTimeService desiredTimeService;

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

    //쿼리 파라미터
    @GetMapping("/applicants")
    public ResponseEntity<Map<String, List<?>>> getApplicantsInfo(){

        return ResponseEntity.ok().body(Map.of(
                "job", registrationService.getApplicantNumbersEachJob(),
                "field", registrationService.getApplicantNumberEachField(),
                "major", personalInformationService.getApplicantNumberEachMajor(),
                "path", pathService.getApplicantNumberEachPath(),
                "time", desiredTimeService.getApplicantNumberEachTime()
        ));
    }



}
