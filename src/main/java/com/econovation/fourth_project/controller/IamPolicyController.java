package com.econovation.fourth_project.controller;

import com.econovation.fourth_project.service.IamPolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IamPolicyController {
    private final IamPolicyService iamPolicyService;

    @PostMapping("/policy")
    public ResponseEntity<String> createPolicy(@RequestBody String version){
        iamPolicyService.createPolicy(version);
        return ResponseEntity.ok().body("성공적으로 생성");
    }
}