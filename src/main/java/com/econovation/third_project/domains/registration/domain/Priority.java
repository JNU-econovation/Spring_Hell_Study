package com.econovation.third_project.domains.registration.domain;

public enum Priority {
    WEB("WEB"),
    APP("APP"),
    AI("AI"),
    GAME("GAME"),
    IoT("IoT"),
    ARVR("AR/VR");

    private String value;
    Priority(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }
}
