package com.econovation.third_project.dto;

import com.econovation.third_project.database.PersonalInformation;
import com.econovation.third_project.domain.Table;
import lombok.Builder;
import java.util.List;

public record DesiredTimeDTO(
        int[] table,
        Integer countOfTime,
        List<PersonalInformation> personalInformations
) {
    @Builder
    public DesiredTimeDTO {
    }

    public static DesiredTimeDTO of(Table table, Integer countOfTime, List<PersonalInformation> personalInformations){
        return DesiredTimeDTO.builder()
                .table(table.toArray())
                .countOfTime(countOfTime)
                .personalInformations(personalInformations)
                .build();
    }
}
