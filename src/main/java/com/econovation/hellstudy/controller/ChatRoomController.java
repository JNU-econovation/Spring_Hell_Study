package com.econovation.hellstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRoomController {

    @GetMapping("/rooms/info")
    public String getChatRoomsInfo(){
        return "";
    }
}
