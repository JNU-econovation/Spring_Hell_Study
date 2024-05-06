package com.econovation.hellstudy.domains.user.service;

import com.econovation.hellstudy.database.Database;
import com.econovation.hellstudy.domains.user.domain.ChatLog;
import com.econovation.hellstudy.domains.user.domain.User;
import com.econovation.hellstudy.domains.user.dto.request.QuitChatRoomRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuitChatRoomUSeCase {
    private final Database database;

    // 채팅방을 나가면 chatLog의 isDeleted를 true로 바꾸고 lastReadCount를 채팅방에 있는 채팅수로 바꿈
    public void execute(QuitChatRoomRequest request) {
        User user = database.getUser(request.userId().toString());
        ChatLog chatLog = findByChatRoomId(request.chatRoomId().toString(), user.getChatLogs());
        Integer lastReadCount = database.getChatMessages(request.chatRoomId().toString()).size();
        chatLog.quitChatRoom(lastReadCount);
    }



    private ChatLog findByChatRoomId (String chatRoomId, List<ChatLog> chatLogs) {
        return chatLogs.stream()
                .filter(cl -> cl.getChatRoomId().equals(chatRoomId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("채팅방이 존재하지 않습니다."));
    }
}
