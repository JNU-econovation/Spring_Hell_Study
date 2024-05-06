package com.econovation.hellstudy.database;

import java.util.List;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class ChatRoom {
    private final List<ChatMessage> chatMessages;
    private final List<String> guests;
    private final List<GuestInfo> guestInfos;

    public ChatRoom(@NonNull List<ChatMessage> chatMessages, @NonNull List<String> guests, @NonNull List<GuestInfo> guestInfos) {
        this.chatMessages = chatMessages;
        this.guests = guests;
        this.guestInfos = guestInfos;
    }
}
