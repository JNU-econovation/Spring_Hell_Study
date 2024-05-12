package com.econovation.third_project.database;

import lombok.Getter;

@Getter
public class Registration {
    // 희망분야 (개발자, 디자이너, PM)
    private String hopeField;

    // 1지망
    private String firstPriority;

    // 2지망
    private String secondPriority;

    // 기수
    private Integer cardinal;

    public Registration(String hopeField, String firstPriority, String secondPriority, Integer cardinal ) {
        this.hopeField = hopeField;
        this.firstPriority = firstPriority;
        this.secondPriority = secondPriority;
        this.cardinal = cardinal;
    }
}
