package com.econovation.third_project.dto;

import lombok.Builder;

public record PathDTO(
        String pathName,
        Integer count
) {

    @Builder
    public PathDTO {
    }

    public static PathDTO of(String pathName, Integer count){
        return PathDTO.builder()
                .pathName(pathName)
                .count(count)
                .build();
    }
}
