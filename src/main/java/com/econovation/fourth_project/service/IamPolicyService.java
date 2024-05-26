package com.econovation.fourth_project.service;

import com.econovation.fourth_project.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IamPolicyService {
    private final Database db;
    public void createPolicy(String version){
        db.createPolicy(version);
    }

}
