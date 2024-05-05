package com.econovation.hellstudy.domains.chat.dto.request;

import com.econovation.hellstudy.database.ChatMessage;

public record CreateChatRequest(Long chatRoomId,
                                ChatMessage chatMessage,
                                Long userId) //요청을 보내는 사용자의 id
{
}
