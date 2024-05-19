package com.econovation.third_project.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.NonNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CreateApplicationReq(
        @NonNull
        RegistrationReq registration,
        @NonNull
        PersonalInformationReq personalInformation,
        @NonNull
        PathReq path,
        @NonNull
        DesiredTimeReq desiredTime
        ){}
