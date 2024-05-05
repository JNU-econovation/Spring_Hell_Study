package com.econovation.hellstudy.common.message;

import com.econovation.hellstudy.database.ChatMessage;
import lombok.Getter;

/**
 * Chat에 관련한 Message
 * 원래 ChatMessage2는 ChatMessage가 되어야 하지만 이미 ChatMessage가 존재하므로 ChatMessage2로 이름을 변경
 */
@Getter
public class ChatMessage2 extends Message{
    private ChatMessage chatMessage;
    private String chatRoomId;

    public ChatMessage2(ChatMessage chatMessage, String chatRoomId) {
        this.chatMessage = chatMessage;
        this.chatRoomId = chatRoomId;
    }
}
