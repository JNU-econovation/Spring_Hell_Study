package com.econovation.third_project.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SupportPath {
    POSTER("홍보 포스터"),
    DEPARTMENT_ANNOUNCEMENT("학과 공지사항"),
    ACQUAINTANCE("지인 소개"),
    INSTAGRAM("인스타그램"),
    EVERYTIME("에브리타임");
    private final String entryPathName;

}
