package com.econovation.fourth_project.controller;

import com.econovation.fourth_project.DTO.CreateStatementReq;
import com.econovation.fourth_project.service.IamStatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IamStatementController {
    private final IamStatementService iamStatementService;

    @PostMapping("/statement")
    public ResponseEntity<?> insertStatement(@RequestBody CreateStatementReq createStatementReq){
        iamStatementService.insertStatement(createStatementReq);
        return ResponseEntity.ok().body("성공적으로 저장~");
    }

}
