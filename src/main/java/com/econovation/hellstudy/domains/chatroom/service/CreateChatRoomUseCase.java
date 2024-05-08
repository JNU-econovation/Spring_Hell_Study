package com.econovation.hellstudy.domains.chatroom.service;

import com.econovation.hellstudy.common.helper.AtomicUtils;
import com.econovation.hellstudy.common.message.ChatRoomMessage;
import com.econovation.hellstudy.common.message.Message;
import com.econovation.hellstudy.common.message.MessageQueue;
import com.econovation.hellstudy.database.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class CreateChatRoomUseCase {
    private final Database database;
    private final MessageQueue messageQueue;
    private final AtomicLong counter = new AtomicLong(0);
    public void execute(String hostId) {
        String chatRoomId = String.valueOf(AtomicUtils.autoIncrement(counter));
        try {
            database.createChatRoom(hostId, chatRoomId);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            addMessageToQueue(hostId, chatRoomId);
        }
    }
    private void addMessageToQueue(String hostId, String chatRoomId) {
        Message chatRoomMessage = new ChatRoomMessage(hostId, chatRoomId);
        messageQueue.push(chatRoomMessage);
    }
}
