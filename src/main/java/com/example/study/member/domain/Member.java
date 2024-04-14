package com.example.study.member.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Member {

    private String name;

    private MemberType type;

    private String uuid;

    @Builder
    public Member(String name, MemberType type) {
        this.name = name;
        this.type = type;
        this.uuid = createUUID();
    }

    private String createUUID(){
        return UUID.randomUUID().toString();
    }

    public static Member createMember(String name, MemberType type){
        return Member.builder()
                .name(name)
                .type(type)
                .build();
    }
}
