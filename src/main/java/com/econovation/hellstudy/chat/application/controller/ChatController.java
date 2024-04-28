package com.econovation.hellstudy.chat.application.controller;


import com.econovation.hellstudy.chat.application.service.ChatService;
import com.econovation.hellstudy.chat.domain.dto.response.GetChatRoomResponseDto;
import com.econovation.hellstudy.common.api.ApiResponse;
import com.econovation.hellstudy.common.api.ApiUtils;
import com.econovation.hellstudy.common.domain.dto.response.AbstractResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chats")
public class ChatController {

    private final ChatService chatService;


    // 단일 채팅방 조회
    @GetMapping("/{chatRoomId}")
    public ApiResponse<AbstractResponseDto> getChatRoom(
            @PathVariable("chatRoomId") Long chatRoomId
    ){
        GetChatRoomResponseDto response = chatService.getChatRoom(chatRoomId);
        return ApiUtils.success(HttpStatus.OK, GetChatRoomResponseDto.getMessage(), response);
    }

    @GetMapping
    public ApiResponse<AbstractResponseDto> getChatRooms(){
        
    }

}
