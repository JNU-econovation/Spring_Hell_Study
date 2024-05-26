package com.econovation.fourth_project.data.validation;

import com.econovation.fourth_project.data.Statement;
import org.springframework.stereotype.Component;

@Component
public class StatementValidator {

    public void validate(Statement statement){
        checkSid(statement.getSid());
        checkPrincipal(statement.getPrincipal());
        checkAction(statement.getAction());
        checkEffect(statement.getEffect());
        checkResource(statement.getResource());
    }

    private boolean checkSid(String sid){

    }

    private boolean checkEffect(String effect){

    }

    private boolean checkPrincipal(String principal){

    }

    private boolean checkPrincipal(Object[] principal){

    }

    private boolean checkAction(String action){

    }

    private boolean checkResource(String resource){

    }

}
