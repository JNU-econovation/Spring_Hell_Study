package com.econovation.hellstudy.domains.user.domain;

import lombok.Getter;

// 어떤 유저가 채팅방에 몇 개의 메시지를 읽었는지 저장하는 클래스
@Getter
public class ChatLog {

    private String chatRoomId;
    private Integer readCount;

    public ChatLog(String chatRoomId, Integer readCount) {
        this.chatRoomId = chatRoomId;
        this.readCount = readCount;
    }

    public void updateReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public void plusReadCount() {
        this.readCount++;
    }
}
