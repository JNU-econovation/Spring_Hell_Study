package com.econovation.hellstudy.chatRoom.dto;

import lombok.Builder;

public record FindRoomsRequest(
        String hostId
) {
    @Builder
    public FindRoomsRequest {
    }
}
