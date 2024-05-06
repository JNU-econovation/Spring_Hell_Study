package com.econovation.hellstudy.database;

import java.util.List;

public class ChatRoom {
    private final List<ChatMessage> chatMessages;
    private final List<String> guests;
    private final List<GuestInfo> guestInfos;

    public ChatRoom(List<ChatMessage> chatMessages, List<String> guests,
            List<GuestInfo> guestInfos) {
        this.chatMessages = chatMessages;
        this.guests = guests;
        this.guestInfos = guestInfos;
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public List<String> getGuests() {
        return guests;
    }

    public List<GuestInfo> getGuestInfos() {
        return guestInfos;
    }
}
