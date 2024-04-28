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

    // k: receiverId, v: Invites
    private Map<String, List<Invite>> invites = new HashMap<>();

    // k: chatRoomId, v: guestInfos
    private Map<String, List<GuestInfo>> guestInfosMap = new HashMap<>();

    // k: blockingUserId, v: blockedUserId
    private Map<String, String> blockMap = new HashMap<>();

    public boolean isChatRoomExisting(String chatRoomId){
        return db.get(chatRoomId) != null;
    }
    public void createBlock(String blockingUserId, String blockedUserId){
        blockMap.put(blockingUserId, blockedUserId);
    }
    public void createInvite(String chatRoomId, Invite invite){
        if (!isChatRoomExisting(chatRoomId)) throw new IllegalArgumentException();
        invites.get(chatRoomId).add(invite);
    }
    public void deleteInvite(String chatRoomId, Invite invite){
        if (!isChatRoomExisting(chatRoomId)) throw new IllegalArgumentException();
        invites.get(chatRoomId).remove(invite);
    }
    public void createGuest(String chatRoomId, String userId){
        guests.get(chatRoomId).add(userId);
    }
    public void createGuestInfo(String chatRoomId, GuestInfo guestInfo){
        List<GuestInfo> guestInfos = guestInfosMap.get(chatRoomId);
        guestInfos.add(guestInfo);
    }

    public GuestInfo findGuestInfo(String chatRoomId, String userId){
        return guestInfosMap.get(chatRoomId).stream()
                .filter(guestInfo->guestInfo.getUserId().equals(userId))
                .findAny()
                .orElseThrow(IllegalAccessError::new);
    }




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


}