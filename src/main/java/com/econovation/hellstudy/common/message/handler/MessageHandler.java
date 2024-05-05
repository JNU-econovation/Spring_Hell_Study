package com.econovation.hellstudy.common.message.handler;

import com.econovation.hellstudy.common.message.Message;
import org.springframework.stereotype.Component;

public interface MessageHandler {
    void handle(Message message);
}
