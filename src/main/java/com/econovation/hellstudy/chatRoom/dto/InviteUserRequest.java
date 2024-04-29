package com.econovation.hellstudy.chatRoom.dto;

import lombok.Builder;

public record InviteUserRequest(
        String chatRoomId,
        String visitorId
) {

    @Builder
    public InviteUserRequest {
    }
}
