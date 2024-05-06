package com.econovation.hellstudy.common.message;

import lombok.Getter;

@Getter
public class InviteMessage extends Message{
    private String chatRoomId;
    private String userId;

    public InviteMessage(String chatRoomId, String userId) {
        this.chatRoomId = chatRoomId;
        this.userId = userId;
    }
}
