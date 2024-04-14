package com.example.study.member.dto;

import lombok.Builder;

public record SignUpMemberRequest(
        String name,
        String type
) {
    @Builder
    public SignUpMemberRequest {
    }
}
