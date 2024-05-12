package com.econovation.third_project.dto;

import com.econovation.third_project.database.PersonalInformation;
import lombok.Builder;

import java.util.List;
import java.util.Map;

public record DesiredTimeDTO(
        Map<int[], Integer> countOfTime,
        List<PersonalInformation> personalInformations
) {
    @Builder
    public DesiredTimeDTO {
    }

    public static DesiredTimeDTO of(){

    }
}
