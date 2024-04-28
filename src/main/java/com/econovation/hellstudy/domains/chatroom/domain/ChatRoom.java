package com.econovation.hellstudy.domains.chatroom.domain;

import com.econovation.hellstudy.domains.user.domain.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChatRoom {
    // 채팅방 초대 받는 사람
    private User host;
}
