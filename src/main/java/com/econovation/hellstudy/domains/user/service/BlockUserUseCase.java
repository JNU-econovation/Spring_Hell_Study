package com.econovation.hellstudy.domains.user.service;

import com.econovation.hellstudy.common.helper.AtomicUtils;
import com.econovation.hellstudy.database.Database;
import com.econovation.hellstudy.domains.user.dto.request.BlockUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service
@RequiredArgsConstructor
public class BlockUserUseCase {
    private final Database database;
    private final AtomicLong counter = new AtomicLong(0);

    /**
     * 여려명을 한꺼번에 차단 할 수 있도록 구현했습니다.
     * @param request -> BlockUserRequest
     */
    public void execute(BlockUserRequest request) {
        long blockId = AtomicUtils.autoIncrement(counter);
        String blockerId = request.blockerId();
        List<String> blockeeIds = request.blockeeIds();
        database.createBlock(String.valueOf(blockId), blockeeIds, blockerId);
    }
}
