package com.econovation.third_project.database;

import com.econovation.third_project.config.SupportPath;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Path{
    String registrationId;
    // 지원 경로
    private SupportPath supportPath;
}
