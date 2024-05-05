package com.econovation.hellstudy.common.message.handler;

import com.econovation.hellstudy.common.message.Message;
import com.econovation.hellstudy.common.message.MessageQueue;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Component
public class MessageFailHandler {

    private final MessageQueue messageQueue;

    public void handleFail(Message message, Exception e){
        message.addException(e);
        message.increaseFailCount();
        if(message.isFailLimitExceeded())
            handleTooManyFails(message);
        else
            messageQueue.push(message);
    }

    private void handleTooManyFails(Message message){
        log.info("최대 실패 횟수로 지정한 " + message.getFailLimit() + "회를 초과했습니다.");
        log.info("예외 리스트---------------------------------------");
        List<Exception> exceptionList = message.getExceptions();
        log.info("실패한 메시지 : " + message);
        for(int i = 0; i < message.getExceptions().size(); i++){
            Exception e = exceptionList.get(i);
            log.error("예외 발생 : " + e.getMessage());
            log.info("----------------------------------");
        }
        log.info("예외 리스트 끝 -----------------------------------");
    }
}
