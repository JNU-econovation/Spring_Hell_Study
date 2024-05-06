package com.econovation.hellstudy.domains.user.controller;

import com.econovation.hellstudy.common.StaticString;
import com.econovation.hellstudy.domains.user.dto.request.BlockUserRequest;
import com.econovation.hellstudy.domains.user.dto.request.QuitChatRoomRequest;
import com.econovation.hellstudy.domains.user.service.BlockUserUseCase;
import com.econovation.hellstudy.domains.user.service.QuitChatRoomUSeCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final BlockUserUseCase blockUserUseCase;
    private final QuitChatRoomUSeCase quitChatRoomUSeCase;
    @PostMapping("/user/block")
    public ResponseEntity<String> block(@RequestBody BlockUserRequest request) {
        blockUserUseCase.execute(request);
        return ResponseEntity.ok(StaticString.BLOCK_SUCCESS);
    }

    @PostMapping("/user/quit")
    public ResponseEntity<String> quitChatRoom(@RequestBody QuitChatRoomRequest request) {
        quitChatRoomUSeCase.execute(request);
        return ResponseEntity.ok(StaticString.QUIT_CHATROOM_SUCCESS);
    }
}
