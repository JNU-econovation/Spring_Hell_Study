package com.econovation.hellstudy.DTO.chat;

public record SendChatReq(String chatRoomId, String fromUserId, String message) {
}
