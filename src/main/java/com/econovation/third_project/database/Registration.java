package com.econovation.third_project.database;

import lombok.Getter;

@Getter
public class Registration {
    // 희망분야
    private String hopeField;

    // 1지망
    private String firstPriority;

    // 2지망
    private String secondPriority;

    public Registration(String hopeField, String firstPriority, String secondPriority) {
        this.hopeField = hopeField;
        this.firstPriority = firstPriority;
        this.secondPriority = secondPriority;
    }
}
