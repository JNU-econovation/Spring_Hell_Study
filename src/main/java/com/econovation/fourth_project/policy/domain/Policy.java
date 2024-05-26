package com.econovation.fourth_project.policy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class Policy {
    private Long id;
    private LocalDate version;
    private Statement statement;

    public static Policy createPolicy(LocalDate version, Statement statement){
        return new Policy(version,statement);
    }

    public Policy(LocalDate version, Statement statement) {
        this.version = version;
        this.statement = statement;
    }
}
