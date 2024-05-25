package com.econovation.third_project.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Job {
    DEVELOPER("개발자"),
    PLANNER("기획자"),
    DESIGNER("디자이너");

    private final String jobName;
}
