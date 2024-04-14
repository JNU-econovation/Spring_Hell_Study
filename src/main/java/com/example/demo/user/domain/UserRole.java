package com.example.demo.user.domain;

public enum UserRole {
    USER("USER"),
    GOVERMENT("GOVERMENT");

    private final String value;

    UserRole(String value) {
        this.value = value;
    }
}
