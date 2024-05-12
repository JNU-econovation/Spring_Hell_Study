package com.econovation.third_project.domain;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Builder
public class AllApplicantStatistics {

    private final Integer cnt;

    private final Map<String, Integer> hopeFieldCnt;

    private final Map<String, Integer> majorCnt;

    private final Map<String, Integer> pathCnt;

    // 이게 난관이네
    private final DesiredTimeStatistics desiredTimes;
}
