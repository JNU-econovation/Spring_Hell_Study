package com.econovation.third_project.database;

import com.econovation.third_project.domain.HopeField;
import com.econovation.third_project.domain.ProgrammerField;
import lombok.Getter;

@Getter
public class Registration {

    private Long registrationId;
    // 희망분야
    private HopeField hopeField;

    // 1지망
    private ProgrammerField firstPriority;

    // 2지망
    private ProgrammerField secondPriority;

    public Registration(String hopeField, String firstPriority, String secondPriority) {
        this.hopeField = HopeField.valueOf(hopeField);
        this.firstPriority = ProgrammerField.valueOf(firstPriority);
        this.secondPriority = ProgrammerField.valueOf(secondPriority);
    }
}
