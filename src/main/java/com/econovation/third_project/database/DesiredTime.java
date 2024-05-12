package com.econovation.third_project.database;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DesiredTime {
    String registrationId;
    // 희망 시간 (11 * 3)의 테이블 형태를 준수합니다.
    private List<int[]> desiredTime;
}

/**
 * 0 -> (0,1)
 * 1 -> (1,2)
 * 2 -> (2,3) ...
 */