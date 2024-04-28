package com.econovation.hellstudy.DTO;

public record SendChatReq(String chatRoomId, String fromUserId, String message) {
}
