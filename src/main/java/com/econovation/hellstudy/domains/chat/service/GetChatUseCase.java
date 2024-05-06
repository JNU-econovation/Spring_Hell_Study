package com.econovation.hellstudy.domains.chat.service;

import com.econovation.hellstudy.database.ChatMessage;
import com.econovation.hellstudy.database.Database;
import com.econovation.hellstudy.domains.chat.domain.Chat;
import com.econovation.hellstudy.domains.chat.dto.request.GetChatRequest;
import com.econovation.hellstudy.domains.chat.dto.response.GetChatResponse;
import com.econovation.hellstudy.domains.user.domain.ChatLog;
import com.econovation.hellstudy.domains.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
// 채팅방에 있는 채팅을 조회하는 UseCase
public class GetChatUseCase {
    private final Database database;

    public GetChatResponse execute(GetChatRequest request) {
        String userId = request.userId().toString();
        String chatRoomId = request.chatRoomId().toString();
        ChatLog chatLog = findByChatRoomId(chatRoomId, database.getUser(userId).getChatLogs());
        List<ChatMessage> chatMessages = database.getChatMessages(chatRoomId);

        chatMessages = sortTimeStamp(chatMessages);
        if(isLeftChatRoom(chatRoomId))
            chatMessages = filterLastReadCount(chatMessages, chatLog.getLastReadCount());

        chatMessages = filterIsNotBlock(userId, chatMessages);
        updateReadCount(userId, chatRoomId,chatLog);
        return GetChatResponse.from(chatMessages);
    }

    // 차단 당하지 않는 메세지만 보여짐
    private List<ChatMessage> filterIsNotBlock(String userId, List<ChatMessage> chatMessages) {
        List<String> blockeeIds = database.getUser(userId).getBlock().getBlockeeIds();
        return chatMessages.stream()
                .filter(cm -> !blockeeIds.contains(cm.fromUserId()))
                .toList();
    }

    // 최신 쪽지가 상단에 보임
    private List<ChatMessage> sortTimeStamp(List<ChatMessage> chatMessages) {
        return chatMessages.stream()
                .sorted(Comparator.comparingLong(ChatMessage::timestamp).reversed())
                .toList();
    }

    // 채팅방에 있는 채팅을 조회하면 readCount를 채팅방에 있는 채팅수와 같게 만들어줌
    private void updateReadCount(String userId, String chatRoomId, ChatLog chatLog) {
        List<ChatMessage> chatMessages = database.getChatMessages(chatRoomId);
        chatLog.updateReadCount(chatMessages.size());
    }

    private ChatLog findByChatRoomId (String chatRoomId, List<ChatLog> chatLogs) {
        return chatLogs.stream()
                .filter(cl -> cl.getChatRoomId().equals(chatRoomId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("채팅방이 존재하지 않습니다."));
    }

    //채팅방 나갔다왔는지 확인
    private boolean isLeftChatRoom(String chatRoomId) {
        User user = database.getUser(chatRoomId);
        ChatLog chatLog = findByChatRoomId(chatRoomId, user.getChatLogs());
        return chatLog.isDeleted();
    }
    /**
     * 채팅방을 나갔다 들어오면 이전 채팅은 안보여야함
     * 해당 채팅방을 나갔는지 확인 -> 나갔다가 다시 들어오면 해당 채팅방의 총 채팅에서 lastReadCount을 뻰 채팅이 보임
     */
    private List<ChatMessage> filterLastReadCount(List<ChatMessage> messages, Integer lastReadCount) {
        return messages.stream()
                .sorted(Comparator.comparingLong(ChatMessage::timestamp))
                .skip(lastReadCount)
                .toList();
    }
}
