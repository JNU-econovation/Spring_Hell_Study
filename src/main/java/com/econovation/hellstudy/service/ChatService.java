package com.econovation.hellstudy.service;

import com.econovation.hellstudy.DTO.ChatListReq;
import com.econovation.hellstudy.DTO.ChatMessageRes;
import com.econovation.hellstudy.DTO.SendChatReq;
import com.econovation.hellstudy.database.ChatMessage;
import com.econovation.hellstudy.database.Database;
import com.econovation.hellstudy.database.GuestInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    private final Database database;

    public ChatService(Database database) {
        this.database = database;
    }

    public void sendChat(SendChatReq sendChatReq) {
        String chatRoomId = sendChatReq.chatRoomId();
        ChatMessage message = new ChatMessage(sendChatReq.fromUserId(), sendChatReq.message(), System.currentTimeMillis());
        //채팅방 있는지 확인
        if (!database.isChatRoomExisting(chatRoomId))
            throw new IllegalArgumentException("채팅방 없음");

        //차단되었는지 확인


        //메세지 보내기
        try {
            database.chat(chatRoomId, message);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<ChatMessageRes> getChatList(ChatListReq chatListReq){

        String userId = chatListReq.userId();
        String chatRoomId = chatListReq.chatRoomId();

        GuestInfo guestInfo = database.findGuestInfo(chatRoomId, userId);

        List<ChatMessage> messageList = database.getChatMessages(chatRoomId);

        return messageList.stream()
                .filter(chatMessage -> chatMessage.timestamp() > guestInfo.getFirstAccessTime())
                .map(chatMessage ->  new ChatMessageRes(chatMessage.fromUserId(), chatMessage.message(), chatMessage.timestamp()))
                .toList();
    }

}
