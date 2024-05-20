package com.econovation.third_project.database;

import java.util.List;

import com.econovation.third_project.domain.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DesiredTime {
    String registrationId;
    private String personalInfoId;
    // 희망 시간 (11 * 3)의 테이블 형태를 준수합니다.
    private List<Table> desiredTime;

}
