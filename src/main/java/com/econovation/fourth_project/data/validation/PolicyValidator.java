package com.econovation.fourth_project.data.validation;

import com.econovation.fourth_project.data.Policy;
import com.econovation.fourth_project.data.Statement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class PolicyValidator {

    private final StatementValidator statementValidator;
    private final OLTEValidator olteValidator;

    public void validate(Policy policy){
        Arrays.stream(policy.getStatement())
                .forEach(statement -> statementValidator.validate(statement));
        olteValidator.validate(policy.getOptionalTopLevelElements());
    }

}
