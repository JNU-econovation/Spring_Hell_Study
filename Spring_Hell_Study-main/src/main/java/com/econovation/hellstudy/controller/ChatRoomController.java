package com.econovation.hellstudy.controller;

import com.econovation.hellstudy.database.ChatMessage;
import com.econovation.hellstudy.database.Database;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatRoomController {

    private final Database database;

    @Autowired
    public ChatRoomController(Database database){
        this.database = database;
    }

    // RequestBody를 각각 넣어주니 오류가 발생하여 하나의 클래스로 만들어서 요청 전송
    // 2차 오류 생성자가 없다는 에러가 나와 AllArgsConstructor를 생성했지만 오류
    // 3차 오류 각각의 setter와 getter를 생성해줬지만 오류
    // 클래스 자체를 static으로 선언해서 해결
    // 현재는 ChatRoomController의 내부 클래스 이므로 ChatRoomController가 생성된 이후에 참조해야한다.
    // controller 가 아닌 DTO 파일로 분리해보기
    public static class ChatRoomReq{
        private String hostId;
        private String chatRoomId;

        public ChatRoomReq(String hostId,String chatRoomId){
            this.hostId = hostId;
            this.chatRoomId = chatRoomId;
        }

        public String getHostId() {
            return hostId;
        }

        public void setHostId(String hostId) {
            this.hostId = hostId;
        }

        public String getChatRoomId() {
            return chatRoomId;
        }

        public void setChatRoomId(String chatRoomId) {
            this.chatRoomId = chatRoomId;
        }
    }

    // try - catch를 controller가 아닌 서비스 파일로 분리해보기
    // 예외 처리도 제대로 해주기
    @PostMapping("/chatting-room")
    public void createChatRoom(@RequestBody ChatRoomReq chatRoomReq){ // 1차 오류 RequestBody를 두개 넣어서 오류 발생
        try{
            database.createChatRoom(chatRoomReq.getHostId(),chatRoomReq.getChatRoomId());
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @GetMapping("/chatting-room/{roomId}")
    public List<ChatMessage> getChatRoomAllMessage(@PathVariable String roomId){
        return database.getChatMessages(roomId);
    }


}
