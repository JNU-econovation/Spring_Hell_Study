package com.econovation.hellstudy.service;

import com.econovation.hellstudy.DTO.ChatRoomListReq;
import com.econovation.hellstudy.DTO.ChatRoomListRes;
import com.econovation.hellstudy.DTO.ExitChatRoomReq;
import com.econovation.hellstudy.database.ChatMessage;
import com.econovation.hellstudy.database.ChatRoom;
import com.econovation.hellstudy.database.Database;
import com.econovation.hellstudy.database.GuestInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomService {
    private final Database database;

    public ChatRoomService(Database database) {
        this.database = database;
    }

    //들어간 채팅방 목록 불러오기
    public List<ChatRoomListRes> getChatRooms(ChatRoomListReq chatRoomListReq){
        String userId = chatRoomListReq.userId();
        List<ChatRoom> chatRooms = database.findChatRoomsByGuest(userId);
        return chatRooms.stream()
                .filter(chatRoom -> {
                    GuestInfo guestInfo = database.findGuestInfo(chatRoom.getChatRoomId(), userId);
                    return guestInfo.getFirstAccessTime() != null;
                })
                .sorted(Comparator.comparing((ChatRoom chatRoom) -> {
                    List<ChatMessage> chatMessages = chatRoom.getChatMessages();
                    return chatMessages.get(chatMessages.size() - 1).timestamp();
                }).reversed())
                .map(chatRoom -> new ChatRoomListRes(chatRoom.getChatRoomId(), chatRoom.getGuests()))
                .toList();
    }

    //채팅방 나가기
    public void exitChatRoom(ExitChatRoomReq exitChatRoomReq) {
        String chatRoomId = exitChatRoomReq.chatRoomId();
        String userId = exitChatRoomReq.userId();

        ChatRoom chatRoom = database.findChatRoom(chatRoomId);
        int guestNumber = chatRoom.getGuests().size();
        if (guestNumber > 2)
            database.deleteGuest(chatRoomId, userId);
        else if (guestNumber == 2)
            database.findGuestInfo(chatRoomId, userId).setFirstAccessTime(null);

    }


}
