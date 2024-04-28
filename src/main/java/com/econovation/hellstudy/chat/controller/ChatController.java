package com.econovation.hellstudy.chat.controller;

import com.econovation.hellstudy.chat.service.GetMessageUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private GetMessageUseCase getMessageUseCase;

    @GetMapping("/")
    public List<String> findAllChatRoom(String userId){
        return
    }

}
