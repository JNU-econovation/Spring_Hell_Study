package com.econovation.third_project.controller;

import com.econovation.third_project.dto.*;
import com.econovation.third_project.service.*;
import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.Registration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminQueryController {
    private final Database database;
    private final ApplicantQueryService applicantQueryService;
    private final MajorQueryService majorQueryService;
    private final SupportPathQueryService supportPathQueryService;
    private final HopeFieldQueryService hopeFieldQueryService;
    private final DesiredTimeQueryService desiredTimeQueryService;

    // 예시 코드
    @PostMapping("/registration")
    public ResponseEntity<Object> postRegistrate(@RequestBody Registration registration) {
        database.register(registration);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/admin/{applicants}/{majors}/{programmers}/{path}/{desiredTime}")
    public ResponseEntity<AdminQueryResponse> getAdmin(
            @PathVariable(required = false) String applicants, @PathVariable(required = false) String majors,
            @PathVariable(required = false) String programmers, @PathVariable(required = false) String path, @PathVariable(required = false) String desiredTime) {


        List<ApplicantDTO> applicantDTOS = applicants.isEmpty() ? null : applicantQueryService.execute();
        List<MajorDTO> majorDTOS = majors.isEmpty() ? null : majorQueryService.execute();
        List<ProgrammerFieldDTO> programmerDTOS = programmers.isEmpty() ? null : hopeFieldQueryService.execute();
        List<PathDTO> pathDTOS = path.isEmpty() ? null : supportPathQueryService.execute();
        List<DesiredTimeDTO> desiredTimeDTOS = desiredTime.isEmpty() ? null :  desiredTimeQueryService.execute();

        return ResponseEntity.ok().body(AdminQueryResponse.builder()
                .applicants(applicantDTOS)
                .majors(majorDTOS)
                .programmers(programmerDTOS)
                .path(pathDTOS)
                .desiredTime(desiredTimeDTOS)
                .build());
    }

}
