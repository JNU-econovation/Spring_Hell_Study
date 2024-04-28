package com.econovation.hellstudy.chat.application.usecase;

import com.econovation.hellstudy.chat.domain.model.ChatRoomModel;

public interface GetChatRoomUseCase {

    public ChatRoomModel getChatRoom(Long chatRoomId);

}
