package com.econovation.fourth_project.policy.dto.request;

import com.econovation.fourth_project.policy.domain.Statement;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDate;
public record CreatePolicyRequest(@JsonFormat(pattern = "yyyy-MM-dd") LocalDate version, Statement statement) {

}
