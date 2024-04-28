package com.econovation.hellstudy.domains.chat.service;

import com.econovation.hellstudy.common.helper.Validation;
import com.econovation.hellstudy.database.ChatMessage;
import com.econovation.hellstudy.database.Database;
import com.econovation.hellstudy.domains.chat.dto.request.CreateChatRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Queue;

@Service
@RequiredArgsConstructor
public class CreateChatUseCase {
    private final Database database;
    private final Validation validation;

    public void execute(CreateChatRequest request) {
        long chatRoomId = request.chatRoomId();
        try {

            database.chat(String.valueOf(chatRoomId), request.chatMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
   }
}