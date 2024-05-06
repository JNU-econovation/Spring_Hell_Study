package com.econovation.hellstudy.service;

import com.econovation.hellstudy.DTO.block.BlockUserReq;
import com.econovation.hellstudy.database.Database;
import com.econovation.hellstudy.database.User;
import org.springframework.stereotype.Service;

@Service
public class BlockService {
    private final Database database;

    public BlockService(Database database) {
        this.database = database;
    }

    public void blockUser(BlockUserReq blockUserReq){
        database.insertBlock(blockUserReq.blockingUserId(), blockUserReq.blockedUserId());
        //TODO: 단둘이 있는 채팅방 나가기
    }

    public boolean isBlockedUser(String blockingUserId, String blockedUserId){
        User user = database.findUser(blockingUserId);
        return user.getBlocks().stream().anyMatch(block -> block.blockedUserId().equals(blockedUserId));
    }
}
