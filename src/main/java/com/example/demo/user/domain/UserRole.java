package com.example.demo.user.domain;

public enum UserRole {
    USER("USER"),
    GOVERNMENT("GOVERNMENT");

    private final String value;

    UserRole(String value) {
        this.value = value;
    }
}
