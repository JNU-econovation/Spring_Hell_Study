package com.econovation.hellstudy.common.message.consumer;

import com.econovation.hellstudy.common.message.Message;
import com.econovation.hellstudy.common.message.handler.MessageHandler;
import com.econovation.hellstudy.common.message.MessageQueue;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Component
@Log4j2
@RequiredArgsConstructor
public class MessageConsumerImpl implements MessageConsumer {
    // MessageHandler 인터페이스를 구현한 클래스들을 주입받음
    private final List<MessageHandler> messageHandlers;
    private final MessageQueue messageQueue;
    private final int threadPoolSize = 10;
    private final ExecutorService executor = Executors.newFixedThreadPool(10);
    private boolean isRunning = false;


    /**
     * 메세지 큐에서 메세지를 가져와서 처리하는 메소드
     * 1초마다 실행
     */
    @Override
    @Scheduled(cron = "0/1 * * * * *")
    public void consume() {
        log.info("Start consuming messages");
        if (!messageQueue.isEmpty() && !isRunning)
            executeThreadPool();
    }

    /**
     * 쓰레드 풀을 생성하고 메세지를 처리하는 메소드
     */
    private void executeThreadPool() {
        isRunning = true;
        log.info(messageQueue.size() + "개의 메세지가 존재 합니다.");
        log.info(threadPoolSize + "개의 쓰레드 풀을 생성 합니다.");

        IntStream.range(0, threadPoolSize).forEach(
                threadNum -> CompletableFuture.runAsync(this::process, executor));
        executor.shutdown();
    }

    /**
     * 메세지를 처리하는 메소드
     */
    private void process() {
        Message message = null;
        while (messageQueue.pop() != null) {
            message = messageQueue.pop();
            handleProcess(message);
        }
        isRunning = false;
    }

    private void handleProcess(Message message) {
        try {
            messageHandlers.forEach(messageHandler -> messageHandler.handle(message));
        } catch (Exception e) {
            log.error("메시지 처리 중 에러 발생");
            message.addException(e);
            message.increaseFailCount();
            // 실패 횟수 증가하면서 다시 메시지를 메세지 큐에 넣음
            messageQueue.push(message);
        }
    }
}
