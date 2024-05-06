package com.econovation.hellstudy.common.message.handler;

import com.econovation.hellstudy.common.message.ChatRoomMessage;
import com.econovation.hellstudy.common.message.InviteMessage;
import com.econovation.hellstudy.common.message.Message;
import com.econovation.hellstudy.common.message.MessageQueue;
import com.econovation.hellstudy.database.Database;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class ChatRoomMessageHandler implements MessageHandler {
    private final Database database;
    private final MessageQueue messageQueue;

    @Override
    public void handle(Message message) {
        log.info("메시지 핸들링 시작");
        try {
            if (message instanceof ChatRoomMessage chatRoom)
                database.createChatRoomNoSleep(chatRoom.getHostId(), chatRoom.getChatRoomId());
            else
                log.info("ChatRoom 타입이 아닙니다.");
        } catch (InterruptedException e) { // invite의 InterruptedException
            log.info("invite의 InterruptedException 발생");
            Thread.currentThread().interrupt();
            addMessageToQueue((ChatRoomMessage) message);
        }
        log.info("메시지 핸들링 종료");
    }
    private void addMessageToQueue(ChatRoomMessage chatRoomMessage) {
        Message message = new InviteMessage(chatRoomMessage.getChatRoomId(), chatRoomMessage.getHostId());
        messageQueue.push(message);
    }
}
