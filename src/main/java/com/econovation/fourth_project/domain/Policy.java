package com.econovation.fourth_project.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class Policy {
    private OptionalTopLevelElement optionalTopLevelElement;
    private List<Statement> statements;

    /**
     *
     * @param target : s3, sqs 등
     * @return
     */
    public List<Statement> findStatements(String target, String httpMethod){
        return statements.stream()
                .filter(statement -> statement.getTargetOfResource().equals(target))
                .filter(statement -> statement.getActionOfResource().equals(httpMethod))
                .toList();
    }

    /**
     * isExcept가 false이고, isAll이 true인
     */

    public List<Statement> findStatementsWhoAnyOne(){
        return statements.stream()
                .filter(statement -> !statement.getPrincipal().getIsExcept())
                .filter(statement -> statement.getPrincipal().getIsAll())
                .toList();
    }



}
