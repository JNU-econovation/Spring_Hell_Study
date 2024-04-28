package com.econovation.hellstudy.chat.service;

import com.econovation.hellstudy.chat.database.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetChatRoomUseCase {
    private final Database database;

    public String execute(String userId){
        return database.getChatRoom(userId).getChatRoomId();
    }
}
