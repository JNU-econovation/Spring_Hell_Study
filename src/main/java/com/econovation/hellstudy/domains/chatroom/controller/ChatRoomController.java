package com.econovation.hellstudy.domains.chatroom.controller;

import com.econovation.hellstudy.common.StaticString;
import com.econovation.hellstudy.domains.chatroom.service.CreateChatRoomUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ChatRoomController {
    private final CreateChatRoomUseCase createChatRoomUseCase;

    @PostMapping("/chat-room/{userId}")
    public ResponseEntity<String> createChatRoom(@PathVariable Long userId) {
        createChatRoomUseCase.execute(userId.toString());
        return ResponseEntity.ok(StaticString.CREATE_CHAT_ROOM_SUCCESS);
    }
}
