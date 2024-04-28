package com.econovation.hellstudy.chat.domain.model;

import com.econovation.hellstudy.chat.domain.dto.request.GetChatRoomRequestDto;
import com.econovation.hellstudy.database.ChatMessage;

import java.util.List;

public record ChatRoomModel(Long chatRoomId, List<ChatMessage> messages) {

    public static ChatRoomModel of(Long chatRoomId, List<ChatMessage> messages){
        return new ChatRoomModel(chatRoomId, messages);
    }

}
