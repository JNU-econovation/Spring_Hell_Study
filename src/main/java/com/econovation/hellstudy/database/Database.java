package com.econovation.hellstudy.database;

import static java.lang.Math.random;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * 이 클래스는 변경하지 않습니다.
 * 단, 기능을 추가할 경우에는 메소드 추가를 허용하며, 수정은 금지합니다.
 */
@Component
public class Database {
    //ChatRoom
    // key: chatRoomId, value: chatMessages
    private Map<String, List<ChatMessage>> db =  new HashMap<>();
    // key: chatRoomId, value: userIds
    private Map<String, List<String>> guests = new HashMap<>();
    // key: chatRoomId, value: guestInfos
    private Map<String, List<GuestInfo>> guestInfosMap = new HashMap<>();

    //User
    // key: userId, value: blocks
    private Map<String, Set<Block>> blocksMap =  new HashMap<>();
    // key: userId, value: invites
    private Map<String, Set<Invite>> invitesMap =  new HashMap<>();
    //key: userId, value: chatRooms
    private Map<String, List<ChatRoom>> chatRoomsMap = new HashMap<>();

    public void createUser(){
        String userId = UUID.randomUUID().toString();
        blocksMap.put(userId, new HashSet<>());
        invitesMap.put(userId, new HashSet<>());
    }
    public void createChatRoom(String hostId) throws InterruptedException {
        String chatRoomId = UUID.randomUUID().toString();
        createChatRoom(hostId, chatRoomId);
        guestInfosMap.put(chatRoomId, new ArrayList<>());
        insertGuest(chatRoomId, hostId);
    }

    public User findUser(String userId){
        return new User(
                userId,
                blocksMap.get(userId),
                invitesMap.get(userId));
    }
    public ChatRoom findChatRoom(String chatRoomId){
        return new ChatRoom(
                chatRoomId,
                db.get(chatRoomId),
                guests.get(chatRoomId),
                guestInfosMap.get(chatRoomId));
    }
    public List<ChatRoom> findChatRoomsByGuest(String guestId){
        List<ChatRoom> chatRooms = new ArrayList<>();
        guests.forEach((chatRoomId, guestIds) -> {
                    if (guestIds.contains(guestId))
                        chatRooms.add(findChatRoom(chatRoomId));
                });
        return chatRooms;
    }
    public GuestInfo findGuestInfo(String chatRoomId, String userId){
        ChatRoom chatRoom = findChatRoom(chatRoomId);
        List<GuestInfo> guestInfos = chatRoom.getGuestInfos();
        return guestInfos.stream()
                .filter(guestInfo -> guestInfo.getUserId().equals(userId))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
    public Invite findInvite(String chatRoomId, String invitingUserId, String invitedUserId){
        Invite inviteToFind = new Invite(chatRoomId, invitedUserId);
        return findUser(invitingUserId).getInvites().stream()
                .filter(invite -> invite.equals(inviteToFind))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void insertGuest(String chatRoomId, String guestId){
        ChatRoom chatRoom = findChatRoom(chatRoomId);
        if (chatRoom.getGuests().size() >= 100)
            throw new IllegalArgumentException("채팅방이 꽉 찼습니다.");
        chatRoom.getGuests().add(guestId);
        //처리 시각 -> 요청 받은 시각으로 바꾸기
        chatRoom.getGuestInfos().add(new GuestInfo(guestId, System.currentTimeMillis()));
    }
    public void insertInvite(String chatRoomId, String invitingUserId, String invitedUserId) throws InterruptedException {
        invite(chatRoomId, invitingUserId);
        User user = findUser(invitingUserId);
        user.getInvites().add(new Invite(chatRoomId, invitedUserId));
    }
    public void insertBlock(String blockingUserId, String blockedUserId){
        User user = findUser(blockingUserId);
        user.getBlocks().add(new Block(blockedUserId));
    }
    public int insertChat(String chatRoomId, ChatMessage chatMessage) throws InterruptedException {
        List<ChatMessage> chatMessages = getChatMessages(chatRoomId);
        int expectedIndex = chatMessages.size();
        chat(chatRoomId, chatMessage);
        return IntStream.rangeClosed(expectedIndex, chatMessages.size() - 1)
                .filter(i-> {
                    ChatMessage savedChatMessage = chatMessages.get(i);
                    return savedChatMessage.fromUserId().equals(chatMessage.fromUserId())
                            && savedChatMessage.timestamp() == chatMessage.timestamp();
                })
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void deleteInvite(String invitingUserId, Invite invite){
        findUser(invitingUserId).getInvites().remove(invite);
    }
    public void deleteGuest(String chatRoomId, String guestId){
        ChatRoom chatRoom = findChatRoom(chatRoomId);
        chatRoom.getGuests().removeIf(guest->guest.equals(guestId));
        chatRoom.getGuestInfos().removeIf(guestInfo -> guestInfo.getUserId().equals(guestId));
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