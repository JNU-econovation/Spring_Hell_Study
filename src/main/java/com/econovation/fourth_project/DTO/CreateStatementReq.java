package com.econovation.fourth_project.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.NonNull;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public record CreateStatementReq(String version,
                                 @NonNull
                                 String effect,
                                 @NonNull
                                 String principal,
                                 String notPrincipal,
                                 String action,
                                 String notAction,
                                 @NonNull
                                 String resource
                                 )
{}
