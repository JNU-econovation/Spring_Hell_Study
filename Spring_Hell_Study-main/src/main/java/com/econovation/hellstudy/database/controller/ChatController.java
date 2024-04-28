package com.econovation.hellstudy.database.controller;

import com.econovation.hellstudy.database.ChatMessage;
import com.econovation.hellstudy.database.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class ChatController {
    private Database database;
    private ChatMessage chatMessage;

    @PostMapping("message")
    public ChatMessage postMessage(@RequestBody ChatMessage chatMessage) throws InterruptedException {

        database.createChatRoom("1","1"); // throws 없을 시 오류 발생
        database.chat("1",chatMessage);

        return chatMessage;
    }

}
