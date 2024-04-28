package com.econovation.hellstudy.domains.chat.dto.request;

import com.econovation.hellstudy.database.ChatMessage;

public record CreateChatRequest(Long chatRoomId, ChatMessage chatMessage) {
}
