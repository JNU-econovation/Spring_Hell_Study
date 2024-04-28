package com.econovation.hellstudy.domains.user.service;

import com.econovation.hellstudy.common.helper.AtomicUtils;
import com.econovation.hellstudy.database.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class BlockUserUseCase {
    private final Database database;
    private final AtomicLong counter = new AtomicLong(0);
    public void execute(Long blockeeId) {
        long blockId = AtomicUtils.autoIncrement(counter);
        database.createBlock(String.valueOf(blockId), String.valueOf(blockeeId));
    }
}
