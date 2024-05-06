package com.econovation.hellstudy.domains.chat.dto.response;

import com.econovation.hellstudy.database.ChatMessage;

import java.util.List;

public record GetChatResponse(List<ChatMessage> chatMessages) {
    public static GetChatResponse from(List<ChatMessage> chatMessages) {
        return new GetChatResponse(chatMessages);
    }
}
