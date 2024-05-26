package com.econovation.fourth_project.controller;

import com.econovation.fourth_project.data.Policy;
import com.econovation.fourth_project.service.IAMService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IAMController {

    private final IAMService service;

    @PostMapping("/check/resource/{resource}")
    public ResponseEntity<Boolean> check(
            @PathVariable("{resource}") String resource,
            @RequestBody Policy policy){
        Boolean response = service.isAvailable(policy);

        return ResponseEntity.ok(response);
    }

}
