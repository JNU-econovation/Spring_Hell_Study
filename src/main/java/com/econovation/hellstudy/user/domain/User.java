package com.econovation.hellstudy.user.domain;

import com.econovation.hellstudy.chat.domain.ChatRoom;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class User {
    private String id;
    private List<ChatRoom> chatRooms = new ArrayList<>();
    private List<User> blockUsers = new ArrayList<>();
}
