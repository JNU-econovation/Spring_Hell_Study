package com.econovation.hellstudy.chat.service;

import com.econovation.hellstudy.chat.database.CreateChatRoomRequestDTO;
import com.econovation.hellstudy.chat.database.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateChatRoomUseCase {
    private final Database database;

    public void execute(CreateChatRoomRequestDTO createChatRoomRequestDTO) throws InterruptedException {
        database.createChatRoom(createChatRoomRequestDTO.hostId(), createChatRoomRequestDTO.chatRoomId());
    }
}
