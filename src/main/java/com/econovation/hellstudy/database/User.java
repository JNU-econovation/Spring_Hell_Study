package com.econovation.hellstudy.database;

import java.util.Set;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class User {
    private final String userId;
    private final Set<Block> blocks;
    private final Set<Invite> invites;

    public User(@NonNull String userId, @NonNull Set<Block> blocks,@NonNull Set<Invite> invites) {
        this.userId = userId;
        this.blocks = blocks;
        this.invites = invites;
    }
}
