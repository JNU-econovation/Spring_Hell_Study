package com.econovation.third_project.dto;

import lombok.Builder;

public record MajorDTO(
        String major,
        Integer count
) {
    @Builder
    public MajorDTO {
    }

    public static MajorDTO of(String major, Integer count){
        return MajorDTO.builder()
                .count(count)
                .major(major)
                .build();
    }
}
