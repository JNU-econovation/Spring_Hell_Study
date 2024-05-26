package com.econovation.fourth_project.service;

import com.econovation.fourth_project.DTO.CreateStatementReq;
import com.econovation.fourth_project.Database;
import com.econovation.fourth_project.mapper.StatementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IamStatementService {
    private final Database db;
    public void insertStatement(CreateStatementReq createStatementReq){
        db.insertStatement(createStatementReq.version(),
                StatementMapper.entityOf(createStatementReq));
    }


}
