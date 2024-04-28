package com.econovation.hellstudy.domains.chatroom.service;

import com.econovation.hellstudy.common.helper.AtomicUtils;
import com.econovation.hellstudy.database.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class CreateChatRoomUseCase {
    private final Database database;
    private final AtomicLong counter = new AtomicLong(0);
    public void execute(Long hostId) {
        long chatRoomId = AtomicUtils.autoIncrement(counter);
        try {
            database.createChatRoom(String.valueOf(hostId), String.valueOf(chatRoomId));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
