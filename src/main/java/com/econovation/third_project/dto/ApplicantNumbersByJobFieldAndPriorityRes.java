package com.econovation.third_project.dto;

import com.econovation.third_project.database.JobField;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public record ApplicantNumbersByJobFieldAndPriorityRes(int priority, JobField jobField, int number) {

}
