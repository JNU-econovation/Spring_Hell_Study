package com.econovation.hellstudy.service;

import com.econovation.hellstudy.DTO.chat.ChatListReq;
import com.econovation.hellstudy.DTO.chat.ChatListRes;
import com.econovation.hellstudy.DTO.chat.ChatReq;
import com.econovation.hellstudy.DTO.chat.ChatRes;
import com.econovation.hellstudy.DTO.chat.SendChatReq;
import com.econovation.hellstudy.database.Block;
import com.econovation.hellstudy.database.ChatMessage;
import com.econovation.hellstudy.database.ChatRoom;
import com.econovation.hellstudy.database.Database;
import com.econovation.hellstudy.database.GuestInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final Database database;

    public ChatService(Database database, InviteService inviteService) {
        this.database = database;
    }

    //카톡에서 1대1 채팅하면 방 만들어지는 것과 같은 기능
    public void createRoomAndChat(){ //메세지, fromuserid, 상대방id
        //차단확인
        //원래 있던 방 확인
        //없으면 새로 만들고
        //있으면 그 방에 나를 입장시킴(setFirstAccessTime(now))
        //채팅 추가
    }
    //원래 있던 방에서 채팅하는 기능
    public void sendChat(SendChatReq sendChatReq) {
        String chatRoomId = sendChatReq.chatRoomId();
        String fromUserId = sendChatReq.fromUserId();
        String message = sendChatReq.message();

        ChatRoom chatRoom = database.findChatRoom(chatRoomId);

        //1인이면 안보내짐

        //2인 채팅방일 경우 상대방이 다시 채팅방을 볼 수 있도록 함
        if (chatRoom.getGuestInfos().size() == 2) {
            //상대방 찾기
            chatRoom.getGuestInfos()
                    .forEach(guestInfo -> guestInfo.setFirstAccessTime(System.currentTimeMillis()));
        }
        ChatMessage chatMessage = new ChatMessage(fromUserId, message, System.currentTimeMillis());

        try {
            long insertedIndex = database.insertChat(chatRoomId, chatMessage);
            chatRoom.getGuestInfos()
                    .forEach(guestInfo -> guestInfo.getUnreadMessageNumbers().add(insertedIndex));
            readChat(insertedIndex, chatRoomId, fromUserId);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public List<ChatListRes> getChatsInChatRoom(ChatListReq chatListReq){
        String userId = chatListReq.userId();
        String chatRoomId = chatListReq.chatRoomId();

        Set<Block> blocks = database.findUser(userId).getBlocks();
        GuestInfo guestInfo = database.findGuestInfo(chatRoomId, userId);
        Map<Long, ChatListRes> chatMessageResMap = new HashMap<>();

        //메세지 당 응답 객체 하나씩 맵에 추가
        long index = -1;
        for(ChatMessage chatMessage : database.getChatMessages(chatRoomId)){
            index++;
            if (chatMessage.timestamp() < guestInfo.getFirstAccessTime())
                continue;
            if (blocks.stream().anyMatch(block -> block.blockedUserId().equals(userId)))
                continue;

            chatMessageResMap.put(index, new ChatListRes(
                    index,
                    chatMessage.fromUserId(),
                    chatMessage.message(),
                    chatMessage.timestamp(),
                    true
            ));
        }
        //안읽음 처리
        guestInfo.getUnreadMessageNumbers().forEach(messageNum-> chatMessageResMap.get(messageNum).setRead(false));
        return new ArrayList<>(chatMessageResMap.values());
    }

    public ChatRes getChat(ChatReq chatReq){
        int chatNumber = chatReq.chatNumber();
        String chatRoomId = chatReq.chatRoomId();
        String readingUserId = chatReq.readingUserId();

        readChat(chatNumber, chatRoomId, readingUserId);
        ChatMessage chatMessage = database.findChatRoom(chatRoomId).getChatMessages().get(chatNumber);
        return new ChatRes(
                chatNumber,
                chatMessage.fromUserId(),
                chatMessage.message(),
                chatMessage.timestamp()
        );
    }

//내부
    private void readChat(long chatNumber, String chatRoomId, String readingUserId){
        database.findGuestInfo(chatRoomId, readingUserId)
                .getUnreadMessageNumbers()
                .remove(chatNumber);
    }
}
