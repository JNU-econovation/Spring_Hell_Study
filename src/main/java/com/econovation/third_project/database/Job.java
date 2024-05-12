package com.econovation.third_project.database;

import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)

public enum Job {
    DEVELOPER(List.of(
            JobField.AI,
            JobField.GAME,
            JobField.APP,
            JobField.IOT,
            JobField.WEB,
            JobField.ARVR
    )),
    PLANNER(List.of()),
    DESIGNER(List.of());

    private final List<JobField> jobFields;


    public List<JobField> getJobFields() {
        return jobFields;
    }
}
