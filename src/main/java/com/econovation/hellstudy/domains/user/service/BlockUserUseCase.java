package com.econovation.hellstudy.domains.user.service;

import com.econovation.hellstudy.common.helper.AtomicUtils;
import com.econovation.hellstudy.database.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class BlockUserUseCase {
    private final Database database;
    private final AtomicInteger counter = new AtomicInteger(0);
    public void execute(Long blockeeId) {
        int id = AtomicUtils.autoIncrement(counter);
        database.createBlock(String.valueOf(id), String.valueOf(blockeeId));
    }
}
