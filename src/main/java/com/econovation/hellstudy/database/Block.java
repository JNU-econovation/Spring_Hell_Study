package com.econovation.hellstudy.database;

import java.util.Objects;

public record Block(String blockedUserId) {

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof Block block)
            return (block.blockedUserId.equals(this.blockedUserId));
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.blockedUserId);
    }
}
