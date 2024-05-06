package com.econovation.hellstudy.domains.chatroom.domain;

import com.econovation.hellstudy.database.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ChatRoom {
    // 채팅방에 있는 사람들
    private List<String> userIds;
    private  List<ChatMessage> chatMessages;
}
