package com.econovation.fourth_project.database;

import com.econovation.fourth_project.data.OptionalTopLevelElements;
import com.econovation.fourth_project.data.Policy;
import com.econovation.fourth_project.data.Statement;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Database {

    private final Map<String, Policy> policies = new HashMap<>();

    public boolean isExists(Policy policy){

        Policy result = policies.values().stream()
                .filter(e -> policy.equals(policy))
                .findFirst()
                .orElse(null);

        return result == null ?  false : true;

    }
}
