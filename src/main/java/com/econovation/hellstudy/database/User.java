package com.econovation.hellstudy.database;

import java.util.Set;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class User {
    private final Set<Block> blocks;
    private final Set<Invite> invites;

    public User(@NonNull Set<Block> blocks, @NonNull Set<Invite> invites) {
        this.blocks = blocks;
        this.invites = invites;
    }

}
