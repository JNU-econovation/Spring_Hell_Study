package com.econovation.hellstudy.controller;

import com.econovation.hellstudy.DTO.chatroom.ChatRoomListReq;
import com.econovation.hellstudy.DTO.chatroom.ChatRoomListRes;
import com.econovation.hellstudy.service.ChatRoomService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRoomController {
    private final ChatRoomService chatRoomService;
    public ChatRoomController(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    @GetMapping("/rooms/info")
    public List<ChatRoomListRes> getChatRoomsInfo(@RequestBody ChatRoomListReq chatRoomListReq){
        return chatRoomService.getChatRooms(chatRoomListReq);
    }
}
