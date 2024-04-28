package com.econovation.hellstudy.domains.user.controller;

import com.econovation.hellstudy.common.StaticMessage;
import com.econovation.hellstudy.domains.user.service.BlockUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final BlockUserUseCase blockUserUseCase;
    @RequestMapping("/user/block/{userId}")
    public ResponseEntity<String> block(@PathVariable Long userId) {
        blockUserUseCase.execute(userId);
        return ResponseEntity.ok(StaticMessage.BLOCK_SUCCESS);
    }
}
