package com.econovation.hellstudy.chat.domain.dto.response;

import com.econovation.hellstudy.chat.domain.model.ChatRoomModel;
import com.econovation.hellstudy.common.domain.dto.response.AbstractResponseDto;

import java.util.List;

public record GetChatRoomsResponseDto(List<ChatRoomModel> chatRooms) implements AbstractResponseDto {

    public static GetChatRoomsResponseDto of(List<ChatRoomModel> models){
        return new GetChatRoomsResponseDto(models);
    }

    public static String getMessage(){
        return "채팅방 목록 조회에 성공하였습니다.";
    }

}
