package com.econovation.third_project.controller;

import com.econovation.third_project.service.ApplicantQueryService;
import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.Registration;
import com.econovation.third_project.service.HopeFieldQueryService;
import com.econovation.third_project.service.MajorQueryService;
import com.econovation.third_project.service.SupportPathQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class AdminQueryController {
    private final Database database;
    private final ApplicantQueryService applicantQueryService;
    private final MajorQueryService majorQueryService;
    private final SupportPathQueryService supportPathQueryService;
    private final HopeFieldQueryService hopeFieldQueryService;

    // 예시 코드
    @PostMapping("/registration")
    public ResponseEntity<Object> postRegistrate(@RequestBody Registration registration) {
        database.register(registration);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/admin")
    public ResponseEntity<Registration> getAdmin(String userId) {
        applicantQueryService.execute();
        majorQueryService.execute();
        hopeFieldQueryService.execute();
        supportPathQueryService.execute();
        hopeFieldQueryService.execute();
        return ResponseEntity.ok().body(database.getRegistration(userId));
    }

}
