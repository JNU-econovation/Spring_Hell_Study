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
    private Field secondPriority;

    public static Registration of(@NonNull String hopeJob, @NonNull String firstJobFieldName, String secondJobFieldName){
        Job job = Job.valueOf(hopeJob.toUpperCase());

        Field firstPriority = Field.valueOf(firstJobFieldName.toUpperCase());
        Field secondPriority = secondJobFieldName != null ?
                Field.valueOf(secondJobFieldName.toUpperCase()) : null;

        return new Registration(job, firstPriority, secondPriority);
    }

    public Field getFirstPriority(){
        return this.firstPriority;
    }
    public Optional<Field> getSecondPriority(){
        return Optional.ofNullable(this.secondPriority);
    }

}
