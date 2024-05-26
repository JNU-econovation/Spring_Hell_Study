package com.econovation.fourth_project.dto;

import lombok.Builder;


public record CheckRequest(

        String id, // 특정 계정

        String userId, // 사용자
        String httpMethod,
        String resource
) {
    @Builder
    public CheckRequest {
    }
}
