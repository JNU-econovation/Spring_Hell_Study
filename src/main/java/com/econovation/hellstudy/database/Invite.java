package com.econovation.hellstudy.database;

import java.util.Objects;

public record Invite(String invitedUserId) {

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof Invite invite) {
            return (invite.invitedUserId.equals(this.invitedUserId));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.invitedUserId);
    }
}
