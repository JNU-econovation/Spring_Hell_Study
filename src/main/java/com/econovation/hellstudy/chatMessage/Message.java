package com.econovation.hellstudy.chatMessage;

import com.econovation.hellstudy.common.Time;
import lombok.Getter;

@Getter
public class Message {

    String hostId;
    String content;
    Boolean isRead;
    Boolean isHost;
    Time time;

}
