package com.econovation.hellstudy.database;

public record Invite(String chatRoomId, String senderId, String receiverId) {
    //TODO: override equals, hashCode
}
