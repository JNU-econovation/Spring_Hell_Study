package com.econovation.hellstudy.domains.chat.domain;

import com.econovation.hellstudy.common.message.Message;
import com.econovation.hellstudy.database.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chat {
    private Long id;
    // 쪽지 읽었는지 유무
    private Boolean isRead;
    // 쪽지 내용
    private ChatMessage chatMessage;
    private String chatRoomId;

    public Chat(ChatMessage chatMessage, String chatRoomId) {
        this.chatMessage = chatMessage;
        this.chatRoomId = chatRoomId;
    }
}
