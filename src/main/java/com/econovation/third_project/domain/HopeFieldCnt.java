package com.econovation.third_project.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HopeFieldCnt {

    private final String hopeField;

    private final Integer cnt;

    public static HopeFieldCnt of(String hopeField, Integer cnt){
        return new HopeFieldCnt(hopeField, cnt);
    }

}
