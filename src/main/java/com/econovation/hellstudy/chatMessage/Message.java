package com.econovation.hellstudy.chatMessage;

import com.econovation.hellstudy.common.Time;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Message {

    String fromUserId;
    String content;
    Boolean isRead;
    Time time;

    @Builder
    public Message(String fromUserId, String content, Boolean isRead, Time time) {
        this.fromUserId = fromUserId;
        this.content = content;
        this.isRead = isRead;
        this.time = time;
    }
}
