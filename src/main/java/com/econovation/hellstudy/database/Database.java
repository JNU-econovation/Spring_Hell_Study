package com.econovation.hellstudy.database;

import static java.lang.Math.random;

import com.econovation.hellstudy.user.User;
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

    // key: userId, value : User
    private Map<String, User> users = new HashMap<>();

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

    public String getNextChatRoomId(){
        int size = db.size();
        return String.valueOf(size + 1);
    }

    public void invite(String chatRoomId, String userId) throws InterruptedException {
        Thread.sleep((long) (random() * 300L + 100));
        List<ChatMessage> chatMessages = db.get(chatRoomId);
        chatMessages.add(new ChatMessage(userId, "초대되었습니다.", System.currentTimeMillis()));
    }
    public List<ChatMessage> getChatMessages(String chatRoomId) {
        return db.get(chatRoomId);
    }

    public List<String> getChatUsers(String chatRoomId){
        return guests.get(chatRoomId);
    }

    public List<String> getMyChatRoomIds(String hostId, List<String> blackListUserId){
        return guests.entrySet().stream()
                .filter(entry -> entry.getValue().contains(hostId) && !entry.getValue().contains(blackListUserId))
                .map(Map.Entry::getKey)
                .toList();
    }

    public ChatMessage getFirstMessage(String chatRoomId){
        return db.get(chatRoomId).get(0);
    }


    public User getUser(String userId){
        return users.get(userId);
    }
}