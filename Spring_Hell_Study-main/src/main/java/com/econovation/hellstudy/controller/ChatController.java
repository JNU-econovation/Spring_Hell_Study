package com.econovation.hellstudy.controller;

import com.econovation.hellstudy.database.ChatMessage;
import com.econovation.hellstudy.database.Database;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final Database database;

    @Autowired
    public ChatController(Database database){
        this.database = database;
    }

    // 채팅의 생성은 항상 채팅방을 생성하고 채팅 생성하기
    // DTO 파일로 분리해보기
    @Getter
    @Setter
    @AllArgsConstructor
    public static class ChatReq{
        private String chatRoomId;
        private ChatMessage chatMessage;
    }

    // try - catch를 controller가 아닌 서비스 파일로 분리해보기
    @PostMapping("/chat") // 채팅 생성
    public void chat(@RequestBody ChatReq chatReq){
        try{
            database.chat(chatReq.getChatRoomId(),chatReq.getChatMessage());
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
