package com.econovation.fourth_project.service;

import com.econovation.fourth_project.data.OptionalTopLevelElements;
import com.econovation.fourth_project.data.Policy;
import com.econovation.fourth_project.data.Statement;
import com.econovation.fourth_project.data.validation.PolicyValidator;
import com.econovation.fourth_project.database.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class IAMService {

    private final Database database;
    private final PolicyValidator validator;

    public Boolean isAvailable(Policy policy){
        isExists(policy);
        validate(policy);

        return Boolean.TRUE;
    }

    private void isExists(Policy policy){
        /** 존재할 경우 */
        if(database.isExists(policy)) throw new RuntimeException();
    }

    private void validate(Policy policy){
        validator.validate(policy);
    }
}
