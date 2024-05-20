package com.econovation.third_project.dto;

import lombok.Builder;

public record ApplicantDTO(
        String hopeField,
        Integer count
) {
    @Builder
    public ApplicantDTO {
    }

    public static ApplicantDTO of(String type, Integer count){
        return ApplicantDTO.builder()
                .hopeField(type)
                .count(count)
                .build();
    }
}
