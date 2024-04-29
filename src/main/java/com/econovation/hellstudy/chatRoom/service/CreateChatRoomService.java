package com.econovation.hellstudy.chatRoom.service;

import com.econovation.hellstudy.database.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateChatRoomService {

    private final Database database;

    public String execute(String hostId){
        String nextChatRoomId = database.getNextChatRoomId();
        try {
            database.createChatRoom(hostId, nextChatRoomId);
        }catch (InterruptedException e) {
            throw new RuntimeException();
        }
        return nextChatRoomId;
    }

}
