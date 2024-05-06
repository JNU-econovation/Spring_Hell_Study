package com.econovation.hellstudy.database;

import java.util.Objects;

public record Invite(String chatRoomId, String invitedUserId) {

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof Invite invite) {
            return (invite.chatRoomId.equals(this.chatRoomId))
                    && (invite.invitedUserId.equals(this.invitedUserId));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatRoomId, this.invitedUserId);
    }
}
