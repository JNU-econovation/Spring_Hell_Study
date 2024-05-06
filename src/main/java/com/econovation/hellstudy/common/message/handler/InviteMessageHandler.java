package com.econovation.hellstudy.common.message.handler;

import com.econovation.hellstudy.common.message.InviteMessage;
import com.econovation.hellstudy.common.message.Message;
import com.econovation.hellstudy.database.Database;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class InviteMessageHandler implements MessageHandler {
    private final Database database;

    @Override
    public void handle(Message message) {
        log.info("메시지 핸들링 시작");
        if (message instanceof InviteMessage invite)
            database.createChatRoomNoAnySleep(invite.getChatRoomId(), invite.getUserId());
        else
            log.info("Invite 타입이 아닙니다.");
        log.info("메시지 핸들링 종료");
    }
}

