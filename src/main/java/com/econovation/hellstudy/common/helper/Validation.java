package com.econovation.hellstudy.common.helper;

import com.econovation.hellstudy.database.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Validation {
    private final Database database;
    public void checkIsBlock(String blockId, String userId) {

    }
}
