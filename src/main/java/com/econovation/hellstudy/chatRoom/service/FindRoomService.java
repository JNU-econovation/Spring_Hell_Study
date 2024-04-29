package com.econovation.hellstudy.chatRoom.service;

import com.econovation.hellstudy.chatRoom.domain.ChatRoom;
import com.econovation.hellstudy.chatRoom.dto.FindRoomsRequest;
import com.econovation.hellstudy.chatRoom.dto.FindRoomsResponse;
import com.econovation.hellstudy.database.ChatMessage;
import com.econovation.hellstudy.database.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindRoomService {

    private final Database database;
    public List<ChatRoom> execute(FindRoomsRequest findRoomsRequest){
        // 블랙리스트 유저 아이디 조회
        List<String> blackListUser = database.getUser(findRoomsRequest.hostId()).getBlackListUser();

        // chatRoomId들을 조회해서 hostId를 가지고 있는 chatRoomId들을 찾아야한다.
        List<String> myChatRoomIds = database.getMyChatRoomIds(findRoomsRequest.hostId(), blackListUser);

        return myChatRoomIds.stream()
                .map(myChatRoomId -> {
                    ChatMessage firstChatMessage = database.getChatMessages(myChatRoomId).stream()
                            .findFirst()
                            .orElseThrow(NullPointerException::new);
                    return ChatRoom.createChatRoom(
                            myChatRoomId,
                            findRoomsRequest.hostId(),
                            firstChatMessage.fromUserId(),
                            firstChatMessage.message(),
                            firstChatMessage.timestamp()
                    );
                })
                .sorted()
                .toList();
    }
}
