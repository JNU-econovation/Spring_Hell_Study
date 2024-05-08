package com.econovation.hellstudy.chatRoom.service;

import com.econovation.hellstudy.chatRoom.dto.InviteUserRequest;
import com.econovation.hellstudy.database.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
@RequiredArgsConstructor
public class InviteUserService {

    private final Database database;
    @Qualifier(value = "threadPoolTaskExecutor") private final Executor threadPoolTaskExecutor;

    @Async
    public void execute(InviteUserRequest inviteUserRequest){
        inviteUserRequest.visitorIds().stream()
                .forEach(visitorId ->
                        CompletableFuture.runAsync(() -> {
                            try {
                                database.invite(inviteUserRequest.chatRoomId(), visitorId);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }, threadPoolTaskExecutor)
                );

    }
}
