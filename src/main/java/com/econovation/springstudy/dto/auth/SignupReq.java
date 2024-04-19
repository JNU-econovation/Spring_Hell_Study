package com.econovation.springstudy.dto.auth;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SignupReq {
    private final String userId;
    private final String password;

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public SignupReq(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
