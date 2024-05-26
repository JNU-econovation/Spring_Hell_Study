package com.econovation.fourth_project.controller;

import com.econovation.fourth_project.dto.CheckRequest;
import com.econovation.fourth_project.service.IAMPolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IAMPolicyController {

    private final IAMPolicyService iamPolicyService;

    @GetMapping("/check/resource")
    public ResponseEntity<Boolean> checkRequest(CheckRequest checkRequest){
        iamPolicyService.execute(checkRequest);
        return ResponseEntity.ok(false);
    }
}
