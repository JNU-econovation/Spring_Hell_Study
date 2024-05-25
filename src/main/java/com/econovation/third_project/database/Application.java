package com.econovation.third_project.database;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;


@Getter
public final class Application {
    private static final AtomicInteger lastUsedId = new AtomicInteger(0);
    @NonNull
    private final Integer applicationId = lastUsedId.getAndIncrement();
    @NonNull
    private final Registration registration;
    @NonNull
    private final PersonalInformation personalInformation;
    @NonNull
    private final Path path;
    @NonNull
    private final DesiredTime desiredTime;

    @Builder
    public Application(Registration registration, PersonalInformation personalInformation,
            Path path,
            DesiredTime desiredTime) {
        this.registration = registration;
        this.personalInformation = personalInformation;
        this.path = path;
        this.desiredTime = desiredTime;
    }
}




