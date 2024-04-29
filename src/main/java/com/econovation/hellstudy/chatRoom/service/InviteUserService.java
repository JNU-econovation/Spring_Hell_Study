package com.econovation.hellstudy.chatRoom.service;

import com.econovation.hellstudy.chatRoom.dto.InviteUserRequest;
import com.econovation.hellstudy.database.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InviteUserService {

    private final Database database;

    public void execute(InviteUserRequest inviteUserRequest){
        try {
            database.invite(inviteUserRequest.chatRoomId(),inviteUserRequest.visitorId());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
