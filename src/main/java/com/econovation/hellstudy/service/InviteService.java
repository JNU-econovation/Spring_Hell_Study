package com.econovation.hellstudy.service;

import com.econovation.hellstudy.DTO.AcceptInviteReq;
import com.econovation.hellstudy.database.Database;
import com.econovation.hellstudy.database.GuestInfo;
import org.springframework.stereotype.Service;

@Service
public class InviteService {
    private final Database database;

    public InviteService(Database database) {
        this.database = database;
    }

    public void acceptInvite(AcceptInviteReq acceptInviteReq){
        String chatRoomId = acceptInviteReq.chatRoomId();
        String userId = acceptInviteReq.userId();
        GuestInfo guestInfo = new GuestInfo(userId, System.currentTimeMillis(), System.currentTimeMillis());

        database.addGuest(chatRoomId, userId);
        database.addGuestInfo(chatRoomId, guestInfo);
    }

}
