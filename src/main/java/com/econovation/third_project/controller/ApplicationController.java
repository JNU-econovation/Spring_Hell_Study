package com.econovation.third_project.controller;

import com.econovation.third_project.dto.CreateApplicationReq;
import com.econovation.third_project.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ApplicationController {
    private final ApplicationService applicationService;

    @PostMapping("/application")
    public ResponseEntity<Integer> createApplication(@RequestBody CreateApplicationReq createApplicationReq){
        return ResponseEntity.ok().body(applicationService.createApplication(createApplicationReq));
    }
}
