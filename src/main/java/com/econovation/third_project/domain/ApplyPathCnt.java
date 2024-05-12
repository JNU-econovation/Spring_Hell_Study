package com.econovation.third_project.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApplyPathCnt {

    private final String path;

    private final Integer cnt;

    public static ApplyPathCnt of(String path, Integer cnt){
        return new ApplyPathCnt(path, cnt);
    }

}
