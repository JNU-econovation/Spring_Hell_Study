package com.econovation.hellstudy.domains.chat.service;

import com.econovation.hellstudy.database.ChatMessage;
import com.econovation.hellstudy.database.Database;
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
        List<ChatMessage> chatMessages = database.getChatMessages(chatRoomId);
        chatMessages = sortTimeStamp(chatMessages);
        chatMessages = filterIsNotBlock(userId, chatMessages);
        updateReadCount(userId, chatRoomId);
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
                .sorted(Comparator.comparingLong(ChatMessage::timestamp))
                .toList();
    }

    // 채팅방에 있는 채팅을 조회하면 readCount를 채팅방에 있는 채팅수와 같게 만들어줌
    private void updateReadCount(String userId, String chatRoomId) {
        User user = database.getUser(userId);
        ChatLog chatLog = filterChatLog(chatRoomId, user.getChatLogs());
        List<ChatMessage> chatMessages = database.getChatMessages(chatRoomId);
        chatLog.updateReadCount(chatMessages.size());
    }

    private ChatLog filterChatLog(String chatRoomId, List<ChatLog> chatLogs) {
        return chatLogs.stream()
                .filter(cl -> cl.getChatRoomId().equals(chatRoomId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("채팅방이 존재하지 않습니다."));
    }
}
