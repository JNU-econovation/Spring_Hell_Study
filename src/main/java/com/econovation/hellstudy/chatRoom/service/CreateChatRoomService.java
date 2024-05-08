package com.econovation.hellstudy.chatRoom.service;

import com.econovation.hellstudy.database.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
@RequiredArgsConstructor
public class CreateChatRoomService {

    private final Database database;
    @Qualifier(value = "threadPoolTaskExecutor") private final Executor threadPoolTaskExecutor;


    @Async
    public String execute(String hostId){
        String nextChatRoomId = database.getNextChatRoomId();

            CompletableFuture.runAsync(() -> {
                        try {
                            database.createChatRoom(hostId, nextChatRoomId);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }, threadPoolTaskExecutor
            );

        return nextChatRoomId;
    }

}
