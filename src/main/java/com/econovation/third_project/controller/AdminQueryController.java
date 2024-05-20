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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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
            @PathVariable(required = false) String applicants,
            @PathVariable(required = false) String majors,
            @PathVariable(required = false) String programmers,
            @PathVariable(required = false) String path,
            @PathVariable(required = false) String desiredTime) throws ExecutionException, InterruptedException {

        CompletableFuture<List<ApplicantDTO>> applicantFuture = applicants.isEmpty()
                ? null
                : CompletableFuture.supplyAsync(() -> applicantQueryService.execute());

        CompletableFuture<List<MajorDTO>> majorFuture = majors.isEmpty()
                ? null
                : CompletableFuture.supplyAsync(() -> majorQueryService.execute());

        CompletableFuture<List<ProgrammerFieldDTO>> programmerFuture = programmers.isEmpty()
                ? null
                : CompletableFuture.supplyAsync(() -> hopeFieldQueryService.execute());

        CompletableFuture<List<PathDTO>> pathFuture = path.isEmpty()
                ? null
                : CompletableFuture.supplyAsync(() -> supportPathQueryService.execute());

        CompletableFuture<List<DesiredTimeDTO>> desiredTimeFuture = desiredTime.isEmpty()
                ? null
                : CompletableFuture.supplyAsync(() -> desiredTimeQueryService.execute());

        CompletableFuture<AdminQueryResponse> completableFuture = CompletableFuture.allOf(applicantFuture, majorFuture, programmerFuture, pathFuture, desiredTimeFuture)
                .thenApply(Void -> AdminQueryResponse.builder()
                        .applicants(applicantFuture.join())
                        .majors(majorFuture.join())
                        .programmers(programmerFuture.join())
                        .path(pathFuture.join())
                        .desiredTime(desiredTimeFuture.join())
                        .build());

        return ResponseEntity.ok().body(completableFuture.get());
    }


}
