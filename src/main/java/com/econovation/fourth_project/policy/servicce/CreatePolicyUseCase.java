package com.econovation.fourth_project.policy.servicce;

import com.econovation.fourth_project.policy.database.Database;
import com.econovation.fourth_project.policy.domain.Policy;
import com.econovation.fourth_project.policy.dto.request.CreatePolicyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatePolicyUseCase {
    private final Database database;

    public void execute(CreatePolicyRequest request) {
        Policy policy = Policy.createPolicy(request.version(), request.statement());
        database.savePolicy(policy);
    }
}
