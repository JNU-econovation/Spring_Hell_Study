package com.econovation.third_project.domains.registration.domain;

public enum HopeField {
    WEB("WEB"),
    APP("APP"),
    AI("AI"),
    GAME("GAME"),
    IoT("IoT"),
    ARVR("AR/VR");

    private String value;
    HopeField(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }
}
