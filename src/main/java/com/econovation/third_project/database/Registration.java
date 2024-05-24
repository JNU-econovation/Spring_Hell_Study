package com.econovation.third_project.database;

import com.econovation.third_project.config.Field;
import com.econovation.third_project.config.Job;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Registration {
    @NonNull
    private Job hopeJob;
    @NonNull
    private Field firstPriority;
    @Getter
    private Field secondPriority;

    public static Registration of(@NonNull String hopeJob, @NonNull String firstJobFieldName, String secondJobFieldName){
        Job job = Job.valueOf(hopeJob.toUpperCase());

        Field firstPriority = Field.valueOf(firstJobFieldName.toUpperCase());
        Field secondPriority = Field.valueOf(secondJobFieldName.toUpperCase());

        return new Registration(job, firstPriority, secondPriority);
    }

}
