package com.econovation.hellstudy.service;

import com.econovation.hellstudy.DTO.AcceptInviteReq;
import com.econovation.hellstudy.DTO.InviteUserReq;
import com.econovation.hellstudy.DTO.RejectInviteReq;
import com.econovation.hellstudy.database.Database;
import com.econovation.hellstudy.database.GuestInfo;
import com.econovation.hellstudy.database.Invite;
import org.springframework.stereotype.Service;

@Service
public class InviteService {
    private final Database database;

    public InviteService(Database database) {
        this.database = database;
    }

    public void inviteUser(InviteUserReq inviteUserReq){
        String chatRoomId = inviteUserReq.chatRoomId();
        String senderId = inviteUserReq.senderId();
        String receiverId = inviteUserReq.receiverId();

        try{
            database.invite(chatRoomId, receiverId);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        //차단 확인

        //이전 초대 존재하는지 확인

        database.createInvite(chatRoomId, new Invite(chatRoomId, senderId, receiverId));
    }

    public void acceptInvite(AcceptInviteReq acceptInviteReq){
        String chatRoomId = acceptInviteReq.chatRoomId();
        String senderId = acceptInviteReq.senderId();
        String receiverId = acceptInviteReq.receiverId();
        long nowMill = System.currentTimeMillis();
        GuestInfo guestInfo = new GuestInfo(receiverId, nowMill, nowMill);

        database.createGuest(chatRoomId, receiverId);
        database.createGuestInfo(chatRoomId, guestInfo);
        database.deleteInvite(chatRoomId, new Invite(chatRoomId, senderId, receiverId));
    }

    public void rejectInvite(RejectInviteReq rejectInviteReq){
        String chatRoomId = rejectInviteReq.chatRoomId();
        String senderId = rejectInviteReq.senderId();
        String receiverId = rejectInviteReq.receiverId();
        database.deleteInvite(chatRoomId, new Invite(chatRoomId, senderId, receiverId));
    }

}
