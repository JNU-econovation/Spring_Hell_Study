package com.econovation.hellstudy.service;

import com.econovation.hellstudy.DTO.invite.AcceptInviteReq;
import com.econovation.hellstudy.DTO.invite.InviteUserReq;
import com.econovation.hellstudy.DTO.invite.RejectInviteReq;
import com.econovation.hellstudy.database.Database;
import com.econovation.hellstudy.database.GuestInfo;
import com.econovation.hellstudy.database.Invite;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InviteService {
    private final Database database;
    private final BlockService blockService;

    public InviteService(Database database, BlockService blockService) {
        this.database = database;
        this.blockService = blockService;
    }

    public void inviteUser(InviteUserReq inviteUserReq){
        String chatRoomId = inviteUserReq.chatRoomId();
        String invitingUserId = inviteUserReq.invitingUserId();
        String invitedUserId = inviteUserReq.invitedUserId();

        List<GuestInfo> guestInfos = database.findChatRoom(chatRoomId).getGuestInfos();
        if (blockService.isBlockedUser(invitedUserId, invitingUserId))
            throw new IllegalArgumentException("당신은 차단되었습니다.");
        if (guestInfos.size() >= 100)
            throw new IllegalArgumentException("100명까지 들어갈 수 있습니다.");
        if (guestInfos.size() == 2){
            guestInfos.forEach(guestInfo -> guestInfo.setFirstAccessTime(System.currentTimeMillis()));
        }

        try {
            database.insertInvite(chatRoomId, invitingUserId, invitedUserId);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void acceptInvite(AcceptInviteReq acceptInviteReq){
        String chatRoomId = acceptInviteReq.chatRoomId();
        String invitingUserId = acceptInviteReq.invitingUserId();
        String invitedUserId = acceptInviteReq.invitedUserId();

        Invite invite = database.findInvite(chatRoomId, invitingUserId, invitedUserId);
        database.insertGuest(chatRoomId, invitedUserId);
        database.deleteInvite(invitingUserId, invite);
    }

    public void rejectInvite(RejectInviteReq rejectInviteReq){
        String chatRoomId = rejectInviteReq.chatRoomId();
        String invitingUserId = rejectInviteReq.invitingUserId();
        String invitedUserId = rejectInviteReq.invitedUserId();

        database.deleteInvite(invitingUserId, new Invite(chatRoomId, invitedUserId));
    }
}
