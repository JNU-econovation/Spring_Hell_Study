package com.econovation.fourth_project.mapper;

import com.econovation.fourth_project.DTO.CreateStatementReq;
import com.econovation.fourth_project.domain.Statement;

public final class StatementMapper {
    //dto-> entity
    public static Statement entityOf(CreateStatementReq createStatementReq){
        //builder?
        return Statement.builder()
                .effect(createStatementReq.effect())
                .action(createStatementReq.action())
                .notAction(createStatementReq.notAction())
                .principal(createStatementReq.principal())
                .notPrincipal(createStatementReq.notPrincipal())
                .resource(createStatementReq.resource())
                .build();
    }
}
