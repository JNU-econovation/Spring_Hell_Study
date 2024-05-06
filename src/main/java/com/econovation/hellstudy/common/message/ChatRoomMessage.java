package com.econovation.hellstudy.common.message;

import lombok.Getter;

@Getter
public class ChatRoomMessage extends Message{
    private String hostId;
    private String chatRoomId;

    public ChatRoomMessage(String hostId, String chatRoomId) {
        this.hostId = hostId;
        this.chatRoomId = chatRoomId;
    }
}
