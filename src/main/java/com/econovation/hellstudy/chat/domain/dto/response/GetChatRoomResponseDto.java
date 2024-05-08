package com.econovation.hellstudy.chat.domain.dto.response;

import com.econovation.hellstudy.chat.domain.model.ChatRoomModel;
import com.econovation.hellstudy.common.domain.dto.response.AbstractResponseDto;

public record GetChatRoomResponseDto(ChatRoomModel chatRoom) implements AbstractResponseDto {

    public static GetChatRoomResponseDto of(ChatRoomModel model){
        return new GetChatRoomResponseDto(model);
    }

    public static String getMessage(){
        return "채팅방 조회에 성공하였습니다.";
    }

}
