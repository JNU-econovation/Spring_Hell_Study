package com.econovation.hellstudy.chatRoom.controller;

import com.econovation.hellstudy.chatRoom.domain.ChatRoom;
import com.econovation.hellstudy.chatRoom.dto.FindRoomsRequest;
import com.econovation.hellstudy.chatRoom.dto.FindRoomsResponse;
import com.econovation.hellstudy.chatRoom.service.FindRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReadChatRoomController {

    private final FindRoomService findRoomService;

    /**
     * 채팅방 리스트 조회 API
     */

    @GetMapping("/chatRoom")
    public ResponseEntity<List<ChatRoom>> findAll(FindRoomsRequest findAllRoomsRequest){
        List<ChatRoom> findRoomsResponses = findRoomService.execute(findAllRoomsRequest);
        return new ResponseEntity<>(findRoomsResponses,HttpStatus.OK);
    }





}
