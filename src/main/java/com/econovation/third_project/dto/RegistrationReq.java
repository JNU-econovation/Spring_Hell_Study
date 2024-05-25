package com.econovation.third_project.dto;

import com.econovation.third_project.database.Registration;

public record RegistrationReq(String job, String firstPriority, String secondPriority) {
    public RegistrationReq{
        System.out.println(job);
    }
    public Registration toEntity(){
        return Registration.of(this.job, this.firstPriority, this.secondPriority);
    }
}
