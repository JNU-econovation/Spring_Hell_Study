package com.econovation.hellstudy.chat.application.service.executor;

import com.econovation.hellstudy.chat.application.usecase.GetChatRoomUseCase;
import com.econovation.hellstudy.chat.domain.model.ChatRoomModel;
import com.econovation.hellstudy.database.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ChatRoomGetter implements GetChatRoomUseCase {

    private final Database database;

    public ChatRoomModel getChatRoom(Long chatRoomId){
        return get(chatRoomId);
    }

    public List<ChatRoomModel> getMyChatRooms(Long userId){
        List<String> myChatRoomIds = database.getMyChatRoomIds(userId.toString());
        List<ChatRoomModel> myChatRooms = new ArrayList<>();


    }

    private ChatRoomModel get(Long chatRoomId){
        return ChatRoomModel.of(chatRoomId, database.getChatMessages(chatRoomId.toString()));
    }
}
