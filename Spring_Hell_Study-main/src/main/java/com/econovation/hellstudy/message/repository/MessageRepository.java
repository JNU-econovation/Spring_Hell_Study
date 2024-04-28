package com.econovation.hellstudy.message.repository;

import com.econovation.hellstudy.database.ChatMessage;

import java.util.List;
import java.util.Optional;

public interface MessageRepository {
    ChatMessage save(String fromUserId, String message, long timestamp);

    Optional<ChatMessage> findChatMessageByUserId(String userId);

    List<ChatMessage> findAllChatMessage();
}
