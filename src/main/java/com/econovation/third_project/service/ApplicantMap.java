package com.econovation.third_project.service;


import com.econovation.third_project.database.Registration;
import java.util.Map;

public class ApplicantMap {
    Map<String, Integer> applicantNum;
    Map<String, int[]> applicantPriority;

    public ApplicantMap(Map<String, Integer> applicantNum, Map<String, int[]> applicantPriority) {
        this.applicantNum = applicantNum;
        this.applicantPriority = applicantPriority;
    }

    public ApplicantMap getApplicant() {
        return new ApplicantMap(applicantNum, applicantPriority);
    }
}
