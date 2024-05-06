package com.econovation.hellstudy.domains.chat.controller;

import com.econovation.hellstudy.common.StaticString;
import com.econovation.hellstudy.domains.chat.dto.request.CreateChatRequest;
import com.econovation.hellstudy.domains.chat.dto.request.GetChatRequest;
import com.econovation.hellstudy.domains.chat.dto.response.GetChatResponse;
import com.econovation.hellstudy.domains.chat.service.CreateChatUseCase;
import com.econovation.hellstudy.domains.chat.service.GetChatUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ChatController {
    private final CreateChatUseCase createChatUseCase;
    private final GetChatUseCase getChatUseCase;

    @PostMapping("/chat")
    public ResponseEntity<String> createChat(@RequestBody CreateChatRequest request) {
        createChatUseCase.execute(request);
        return ResponseEntity.ok(StaticString.CREATE_CHAT_SUCCESS);
    }

    @GetMapping("/chat")
    public ResponseEntity<GetChatResponse> getChat(@RequestBody GetChatRequest request) {
        GetChatResponse response = getChatUseCase.execute(request);
        return ResponseEntity.ok(response);
    }
}
