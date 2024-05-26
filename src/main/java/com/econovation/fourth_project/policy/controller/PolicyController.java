package com.econovation.fourth_project.policy.controller;

import com.econovation.fourth_project.policy.common.StaticMessage;
import com.econovation.fourth_project.policy.dto.request.CheckResourceRequest;
import com.econovation.fourth_project.policy.dto.request.CreatePolicyRequest;
import com.econovation.fourth_project.policy.servicce.CreatePolicyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PolicyController {
    private final CreatePolicyUseCase createPolicyUseCase;

    @PostMapping("/policy")
    public ResponseEntity<String> createPolicy(@RequestBody CreatePolicyRequest request) {
        createPolicyUseCase.execute(request);
        return ResponseEntity.ok(StaticMessage.SUCCESS_CREATE_POLICY);
    }

    @GetMapping("/check/resource/{resource}")
    public ResponseEntity<Boolean> checkResource(@RequestBody CheckResourceRequest request, @PathVariable String resource) {

    }

}
