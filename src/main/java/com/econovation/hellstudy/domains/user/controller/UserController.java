package com.econovation.hellstudy.domains.user.controller;

import com.econovation.hellstudy.common.StaticMessage;
import com.econovation.hellstudy.domains.user.dto.request.BlockUserRequest;
import com.econovation.hellstudy.domains.user.service.BlockUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final BlockUserUseCase blockUserUseCase;
    @PostMapping("/user/block")
    public ResponseEntity<String> block(@RequestBody BlockUserRequest request) {
        blockUserUseCase.execute(request);
        return ResponseEntity.ok(StaticMessage.BLOCK_SUCCESS);
    }
}
