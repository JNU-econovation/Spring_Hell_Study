package com.econovation.hellstudy.controller;

import com.econovation.hellstudy.DTO.chat.ChatListReq;
import com.econovation.hellstudy.DTO.chat.ChatListRes;
import com.econovation.hellstudy.DTO.chat.SendChatReq;
import com.econovation.hellstudy.service.ChatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/sending")
    public void sendChat(@RequestBody SendChatReq sendChatReq){
        chatService.sendChat(sendChatReq);
    }
    @GetMapping("/list")
    public List<ChatListRes> getChatList(@RequestBody ChatListReq chatListReq){
        return chatService.getChatsInChatRoom(chatListReq);
    }
}
