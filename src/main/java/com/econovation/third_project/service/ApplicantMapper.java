package com.econovation.third_project.service;


import java.util.Map;

public class ApplicantMapper {
    Map<String, Integer> applicantNum;
    Map<String, int[]> applicantPriority;

    public ApplicantMapper(Map<String, Integer> applicantNum, Map<String, int[]> applicantPriority) {
        this.applicantNum = applicantNum;
        this.applicantPriority = applicantPriority;
    }
}
