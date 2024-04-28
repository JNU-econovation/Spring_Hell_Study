package com.econovation.hellstudy.chat.application.service;

import com.econovation.hellstudy.chat.application.service.executor.ChatRoomGetter;
import com.econovation.hellstudy.chat.application.usecase.GetChatRoomUseCase;
import com.econovation.hellstudy.chat.domain.dto.response.GetChatRoomResponseDto;
import com.econovation.hellstudy.chat.domain.dto.response.GetChatRoomsResponseDto;
import com.econovation.hellstudy.chat.domain.model.ChatRoomModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private ChatRoomGetter chatRoomGetter;

    public GetChatRoomResponseDto getChatRoom(Long chatRoomId){
        ChatRoomModel model = get(chatRoomId);

        return GetChatRoomResponseDto.of(model);
    }

    public GetChatRoomsResponseDto getChatRooms(Long userId){
        
    }

    private ChatRoomModel get(Long chatRoomId){
        return chatRoomGetter.getChatRoom(chatRoomId);
    }

}
