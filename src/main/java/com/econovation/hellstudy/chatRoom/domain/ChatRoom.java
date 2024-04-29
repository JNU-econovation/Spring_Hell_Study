package com.econovation.hellstudy.chatRoom.domain;

import com.econovation.hellstudy.chatMessage.Message;
import com.econovation.hellstudy.common.Time;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ChatRoom implements Comparable<ChatRoom>{

    private String chatRoomId;
    private String hostId;
    private Message firstMessage;
    @Builder
    public ChatRoom(String chatRoomId, String hostId, Message firstMessage) {
        this.chatRoomId = chatRoomId;
        this.hostId = hostId;
        this.firstMessage = firstMessage;
    }

    public static ChatRoom createChatRoom(String chatRoomId, String hostId, String fromUserId, String content, long cratedAt){
        return ChatRoom.builder()
                .chatRoomId(chatRoomId)
                .hostId(hostId)
                .firstMessage(
                        Message.builder()
                        .fromUserId(fromUserId)
                        .content(content)
                        .isRead(false)
                        .time(new Time(cratedAt))
                        .build()
                ).build();
    }

    @Override
    public int compareTo(ChatRoom o) {
        if(this.firstMessage.getTime().getCreatedAt().isEqual(o.firstMessage.getTime().getCreatedAt())){
            return 0;
        } else if (this.firstMessage.getTime().getCreatedAt().isAfter(o.firstMessage.getTime().getCreatedAt())) {
            return -1;
        }else{
            return 1;
        }
    }
}
