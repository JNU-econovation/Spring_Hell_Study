package com.econovation.third_project.dto;

import lombok.Builder;

import java.util.List;

public record AdminQueryResponse(
        List<ApplicantDTO> applicants,
        List<MajorDTO> majors,
        List<ProgrammerFieldDTO> programmers,
        List<PathDTO> path,
        List<DesiredTimeDTO> desiredTime
) {

    @Builder
    public AdminQueryResponse {
    }


}
