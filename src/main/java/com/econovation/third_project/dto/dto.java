package com.econovation.third_project.dto;

import com.econovation.third_project.controller.AggregateQuery;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class dto extends AggregateQuery {
    String registrationId;
    // 희망 시간 (11 * 3)의 테이블 형태를 준수합니다.
    private List<int[]> desiredTime;
}
