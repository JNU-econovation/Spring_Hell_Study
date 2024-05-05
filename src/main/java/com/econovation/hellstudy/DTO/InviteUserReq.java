package com.econovation.hellstudy.DTO;

public record InviteUserReq(String chatRoomId, String invitingUserId, String invitedUserId) {
    //TODO: toEntity
}
