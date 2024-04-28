package com.econovation.hellstudy.message.repository;


import com.econovation.hellstudy.database.ChatMessage;

import java.util.List;
import java.util.Optional;

public class MemoryMessageRepository implements MessageRepository {

    @Override
    public ChatMessage save(String fromUserId, String message, long timestamp) {
        return null;
    }

    @Override
    public Optional<ChatMessage> findChatMessageByUserId(String userId) {
        return Optional.empty();
    }

    @Override
    public List<ChatMessage> findAllChatMessage() {
        return null;
    }
}
