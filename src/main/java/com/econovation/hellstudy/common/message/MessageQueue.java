package com.econovation.hellstudy.common.message;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
@RequiredArgsConstructor
public class MessageQueue {
    private final Queue<Message> queue = new ConcurrentLinkedQueue<>();

    public void push(Message message) {
        queue.add(message);
    }

    public Message pop() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
