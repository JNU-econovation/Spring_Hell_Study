package com.econovation.hellstudy.domains.chat.controller;

import com.econovation.hellstudy.common.StaticString;
import com.econovation.hellstudy.domains.chat.dto.request.CreateChatRequest;
import com.econovation.hellstudy.domains.chat.service.CreateChatUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ChatController {
    private final CreateChatUseCase createChatUseCase;

    @PostMapping("/chat")
    public ResponseEntity<String> createChat(@RequestBody CreateChatRequest request) {
        createChatUseCase.execute(request);
        return ResponseEntity.ok(StaticString.CREATE_CHAT_SUCCESS);
    }
}
