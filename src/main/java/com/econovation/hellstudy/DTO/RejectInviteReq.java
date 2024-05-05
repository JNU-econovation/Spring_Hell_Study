package com.econovation.hellstudy.DTO;

public record RejectInviteReq(String chatRoomId, String invitingUserId, String invitedUserId) {
}
