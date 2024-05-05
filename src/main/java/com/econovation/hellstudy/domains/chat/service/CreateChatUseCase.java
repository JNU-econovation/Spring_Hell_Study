package com.econovation.hellstudy.domains.chat.service;

import com.econovation.hellstudy.common.helper.Validation;
import com.econovation.hellstudy.common.message.ChatMessage2;
import com.econovation.hellstudy.common.message.Message;
import com.econovation.hellstudy.common.message.MessageQueue;
import com.econovation.hellstudy.database.ChatMessage;
import com.econovation.hellstudy.database.Database;
import com.econovation.hellstudy.domains.chat.domain.Chat;
import com.econovation.hellstudy.domains.chat.dto.request.CreateChatRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Queue;

@Service
@RequiredArgsConstructor
public class CreateChatUseCase {
    private final Database database;
    private final Validation validation;
    private final MessageQueue messageQueue;

    public void execute(CreateChatRequest request) {
        long chatRoomId = request.chatRoomId();
        try {
            database.chat(String.valueOf(chatRoomId), request.chatMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            addMessageToQueue(request.chatMessage(), String.valueOf(chatRoomId));
        }
   }

    /**
     * chat 메서드에서 쓰레드가 sleep할 때 데이터 유실을 방지 하기 위해 MessageQueue에 Chat을 push한다.
     * @param chatMessage
     * @param chatRoomId
     */
   private void addMessageToQueue(ChatMessage chatMessage, String chatRoomId) {
       Message message = new ChatMessage2(chatMessage, chatRoomId);
       messageQueue.push(message);
   }
}