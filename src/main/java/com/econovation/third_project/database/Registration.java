package com.econovation.third_project.database;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Registration {
    @NonNull
    private Job hopeJob;
    @NonNull
    private Optional<JobField> firstPriority;
    @NonNull
    private Optional<JobField> secondPriority;

    public static Registration of(String hopeJob, String firstPriority, String secondPriority){
        Job job = Job.valueOf(hopeJob.toUpperCase()); //없으면 Illegal

        Optional<JobField> firstJobField = job.getJobFields().stream().filter(jf -> jf.name().equals(firstPriority)).findAny();
        Optional<JobField> secondJobField = job.getJobFields().stream().filter(jf -> jf.name().equals(secondPriority)).findAny();

        return new Registration(job, firstJobField, secondJobField);
    }

}
