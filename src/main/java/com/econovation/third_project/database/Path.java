package com.econovation.third_project.database;

import com.econovation.third_project.controller.AggregateQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Path {
    String registrationId;
    // 지원 경로
    private String supportPath;
}
