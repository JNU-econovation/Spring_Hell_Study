package com.econovation.third_project.dto;

import com.econovation.third_project.database.PersonalInformation;

public record PersonalInformationReq(
        String name,
        String phoneNumber,
        Integer studentId,
        Integer grade,
        Integer semester,
        String major,
        String doubleMajor,
        String minor,
        String email) {
    public PersonalInformation toEntity(){
        return PersonalInformation.builder()
                .name(this.name)
                .doubleMajor(this.doubleMajor)
                .email(this.email)
                .grade(this.grade)
                .major(this.major)
                .minor(this.minor)
                .phoneNumber(this.phoneNumber)
                .semester(this.semester)
                .studentId(this.studentId)
                .build();
    }
}
