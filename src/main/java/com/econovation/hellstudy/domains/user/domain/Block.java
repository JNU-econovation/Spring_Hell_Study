package com.econovation.hellstudy.domains.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Block {
    // 차단 하는 사람
    private String blockerId;
    // 차단 당하는 사람
    private List<String> blockeeIds;
}
