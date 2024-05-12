package com.econovation.third_project.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MajorCnt {

    private final String major;

    private final Integer cnt;

    public static MajorCnt of(String major, Integer cnt){
        return new MajorCnt(major, cnt);
    }

}
