package com.econovation.hellstudy.database;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private final Set<Block> blocks;
    private final Set<Invite> invites;

    public User(Set<Block> blocks, Set<Invite> invites) {
        this.blocks = blocks;
        this.invites = invites;
    }

    public Set<Block> getBlocks() {
        return blocks;
    }

    public Set<Invite> getInvites() {
        return invites;
    }
}
