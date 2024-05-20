package com.econovation.third_project.dto;

import lombok.Builder;

public record ProgrammerFieldDTO(
        String field,
        Integer firstPriorityCount,
        Integer secondPriorityCount
) {

    @Builder
    public ProgrammerFieldDTO {
    }

    public static ProgrammerFieldDTO of(String field, Integer firstPriorityCount, Integer secondPriorityCount){
        return ProgrammerFieldDTO.builder()
                .field(field)
                .firstPriorityCount(firstPriorityCount)
                .secondPriorityCount(secondPriorityCount)
                .build();
    }
}
