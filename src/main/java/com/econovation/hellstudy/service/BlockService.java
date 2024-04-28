package com.econovation.hellstudy.service;

import com.econovation.hellstudy.DTO.BlockUserReq;
import com.econovation.hellstudy.database.Database;
import org.springframework.stereotype.Service;

@Service
public class BlockService {
    private final Database database;

    public BlockService(Database database) {
        this.database = database;
    }

    public void blockUser(BlockUserReq blockUserReq){
        database.createBlock(blockUserReq.blockingUserId(), blockUserReq.blockedUserId());
    }
}
