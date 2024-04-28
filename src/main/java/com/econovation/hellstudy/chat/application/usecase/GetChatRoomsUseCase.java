package com.econovation.hellstudy.chat.application.usecase;

import com.econovation.hellstudy.chat.domain.model.ChatRoomModel;

import java.util.List;

public interface GetChatRoomsUseCase {

    public List<ChatRoomModel> getChatRooms(Long userId);
}
