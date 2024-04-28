package com.econovation.hellstudy.domains.chat.domain;

import com.econovation.hellstudy.database.ChatMessage;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chat {
    private Long id;
    // 쪽지 읽었는지 유무
    private Boolean isRead;
    // 쪽지 내용
    private ChatMessage chatMessage;
}
