package com.example.study.member.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {

    private String name;

    private MemberType type;

    private Long buyCount;
    @Builder
    public Member(String name, MemberType type) {
        this.name = name;
        this.type = type;
    }

}
