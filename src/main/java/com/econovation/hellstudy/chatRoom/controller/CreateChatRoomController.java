package com.econovation.hellstudy.chatRoom.controller;

import com.econovation.hellstudy.chatRoom.dto.InviteUserRequest;
import com.econovation.hellstudy.chatRoom.service.CreateChatRoomService;
import com.econovation.hellstudy.chatRoom.service.InviteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class CreateChatRoomController {

    private final CreateChatRoomService createChatRoomService;
    private final InviteUserService inviteUserService;

    /**
     * 채팅방 생성 API
     */

    @PostMapping("/chatRoom")
    public ResponseEntity<String> create(String hostId){
        String chatRoomId = createChatRoomService.execute(hostId);
        return new ResponseEntity<>(chatRoomId,HttpStatus.CREATED);
    }

    /**
     * 초대 API
     */

    @PostMapping("/chatRoom/user")
    public ResponseEntity<Void> invite(InviteUserRequest inviteUserRequest){
        inviteUserService.execute(inviteUserRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
