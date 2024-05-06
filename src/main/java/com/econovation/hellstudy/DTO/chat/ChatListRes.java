package com.econovation.hellstudy.DTO.chat;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ChatListRes {
    long messageNumber;
    String userId;
    String message;
    long createdTime;
    @Setter
    boolean read;

    public ChatListRes(long messageNumber, String userId, String message, long createdTime,
            boolean read) {
        this.messageNumber = messageNumber;
        this.userId = userId;
        this.message = message;
        this.createdTime = createdTime;
        this.read = read;
    }
}
