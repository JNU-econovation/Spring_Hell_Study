package com.econovation.hellstudy.common.message.handler;

import com.econovation.hellstudy.common.message.Message;
import com.econovation.hellstudy.database.Database;
import com.econovation.hellstudy.domains.chat.domain.Chat;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Log4j2
@Component
public class ChatMessageHandler implements MessageHandler{
    private final Database database;
    @Override
    public void handle(Message message) {
        log.info("메시지 핸들링 시작");
        if(message instanceof Chat chat)
            database.chatNoSleep(chat.getChatRoomId(), chat.getChatMessage());
        else
            log.info("Chat 타입이 아닙니다.");
        log.info("메시지 핸들링 종료");
    }
}
