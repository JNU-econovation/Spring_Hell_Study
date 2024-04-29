package com.econovation.hellstudy.chatRoom.domain;

import com.econovation.hellstudy.common.Time;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ChatRoom {

    private Long chatRoomId;
    private Long hostId;
    private Long visitorId;
    private Time time;
    @Builder
    public ChatRoom(Long chatRoomId, Long hostId, Long visitorId, Time time) {
        this.chatRoomId = chatRoomId;
        this.hostId = hostId;
        this.visitorId = visitorId;
        this.time = time;
    }

}
