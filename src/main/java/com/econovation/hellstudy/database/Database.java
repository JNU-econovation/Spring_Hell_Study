package com.econovation.hellstudy.database;

import static java.lang.Math.random;

import org.springframework.stereotype.Component;
import java.util.*;

/**
 * 이 클래스는 변경하지 않습니다.
 * 단, 기능을 추가할 경우에는 메소드 추가를 허용하며, 수정은 금지합니다.
 */
@Component
public class Database {
    // key: chatRoomId, value: chatMessages
    private Map<String, List<ChatMessage>> db =  new HashMap<>();
    // key: chatRoomId, value: userIds
    private Map<String, List<String>> guests = new HashMap<>();
    // key : blockId, value : userIds
    private Map<String, List<String>> blocks = new HashMap<>();

    public void chat(String chatRoomId, ChatMessage message) throws InterruptedException {
        Thread.sleep((long) (random() * 300L + 100));
        List<ChatMessage> chatMessages = db.get(chatRoomId);
        chatMessages.add(message);
        db.put(chatRoomId, chatMessages);
    }
    public void createChatRoom(String hostId, String chatRoomId) throws InterruptedException {
        Thread.sleep((long) (random() * 300L + 100));
        db.put(chatRoomId,new ArrayList<>());
        // host를 초대한다
        invite(chatRoomId, hostId);
        List<String> userIds = new ArrayList<>();
        userIds.add(hostId);
        guests.put(chatRoomId, userIds);
    }
    public void invite(String chatRoomId, String userId) throws InterruptedException {
        Thread.sleep((long) (random() * 300L + 100));
        List<ChatMessage> chatMessages = db.get(chatRoomId);
        chatMessages.add(new ChatMessage(userId, "초대되었습니다.", System.currentTimeMillis()));
    }
    public List<ChatMessage> getChatMessages(String chatRoomId) {
        return db.get(chatRoomId);
    }

    public void createBlock(String blockId, String blockeeId) {
        List<String> userIds = new ArrayList<>();
        // 어떤 유저를 차단하다.
        userIds.add(blockeeId);
        blocks.put(blockId, userIds);
    }
}