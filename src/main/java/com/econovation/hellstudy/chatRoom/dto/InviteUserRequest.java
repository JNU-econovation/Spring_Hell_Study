package com.econovation.hellstudy.chatRoom.dto;

import lombok.Builder;

import java.util.List;

public record InviteUserRequest(
        String chatRoomId,
        List<String> visitorIds
) {

    @Builder
    public InviteUserRequest {
    }
}
