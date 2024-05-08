package com.econovation.hellstudy.domains.chat.service;

import com.econovation.hellstudy.common.message.ChatMessage2;
import com.econovation.hellstudy.common.message.Message;
import com.econovation.hellstudy.common.message.MessageQueue;
import com.econovation.hellstudy.database.ChatMessage;
import com.econovation.hellstudy.database.Database;
import com.econovation.hellstudy.domains.chat.dto.request.CreateChatRequest;
import com.econovation.hellstudy.domains.user.domain.ChatLog;
import com.econovation.hellstudy.domains.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateChatUseCase {
    private final Database database;
    private final MessageQueue messageQueue;


    public void execute(CreateChatRequest request) {
        String chatRoomId = request.chatRoomId().toString();
        String userId = request.userId().toString();
        try {
            database.chat(chatRoomId, request.chatMessage());
            updateReadCount(userId, chatRoomId);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            addMessageToQueue(request.chatMessage(), chatRoomId);
        }
   }

    /**
     * chat 메서드에서 쓰레드가 sleep할 때 데이터 유실을 방지 하기 위해 MessageQueue에 Chat을 push한다.
     * @param chatMessage
     * @param chatRoomId
     */
   private void addMessageToQueue(ChatMessage chatMessage, String chatRoomId) {
       Message message = new ChatMessage2(chatMessage, chatRoomId);
       messageQueue.push(message);
   }
    // 자기가 보낸 메세지는 자기가 읽었다고 처리
    private void updateReadCount(String userId, String chatRoomId) {
        User user = database.getUser(userId);
        ChatLog chatLog = filterChatLog(chatRoomId, user.getChatLogs());
        chatLog.plusReadCount();
    }

    private ChatLog filterChatLog(String chatRoomId, List<ChatLog> chatLogs) {
        return chatLogs.stream()
                .filter(cl -> cl.getChatRoomId().equals(chatRoomId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("채팅방이 존재하지 않습니다."));
    }
}