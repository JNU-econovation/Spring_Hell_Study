package com.econovation.hellstudy.domains.user.domain;

import com.econovation.hellstudy.domains.chatroom.domain.ChatRoom;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class User {
    private Block block;
    private List<ChatRoom> chatRooms;
    private List<ChatLog> chatLogs = new ArrayList<>();

    public User(Block block, List<ChatRoom> chatRooms) {
        this.block = block;
        this.chatRooms = chatRooms;
    }

    public void addChatLog(ChatLog chatLog) {
        chatLogs.add(chatLog);
    }
}
