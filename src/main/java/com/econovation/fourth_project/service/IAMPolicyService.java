package com.econovation.fourth_project.service;

import com.econovation.fourth_project.database.Database;
import com.econovation.fourth_project.domain.Effect;
import com.econovation.fourth_project.domain.Policy;
import com.econovation.fourth_project.domain.Statement;
import com.econovation.fourth_project.dto.CheckRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IAMPolicyService {
    private final Database database;
    public Boolean execute(CheckRequest checkRequest){

        Policy policy = database.findPolicy(checkRequest.id());
        List<Statement> statements = policy.findStatements(checkRequest.resource(), checkRequest.httpMethod());

        List<Statement> statementList = statements.stream()
                .filter(statement -> statement.getEffect().equals(Effect.Deny))
                .filter(statement -> !statement.getPrincipal().getIsExcept())
                .filter(statement -> statement.getPrincipal().getIsAll())
                .toList();

        if(statementList.isEmpty()){
            return false;
        }

        statements.stream()
                .filter(statement -> statement.getEffect().equals(Effect.Allow))
                .filter()

        return true;

    }
}
