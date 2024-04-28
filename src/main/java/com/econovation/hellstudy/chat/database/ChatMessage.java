package com.econovation.hellstudy.chat.database;


/**
 * 이 클래스는 변경하지 않습니다.
 */
public record ChatMessage(String fromUserId, String message, long timestamp) {
}
