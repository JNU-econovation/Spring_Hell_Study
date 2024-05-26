package com.econovation.fourth_project;

import com.econovation.fourth_project.domain.Policy;
import com.econovation.fourth_project.domain.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public final class Database {
    private final Map<String, Policy> policies = new HashMap<>();

    public Database() {
        createPolicy("2012-10-17");
    }

    //TODO: 줄일 수 있을까
    public void createPolicy(String version){
        if (policies.containsKey(version))
            throw new IllegalArgumentException();
        policies.put(version, new Policy(version));
    }

    public Policy findPolicy(String version){
        return Optional.ofNullable(policies.get(version))
                .orElseThrow(IllegalAccessError::new);
    }

    public void insertStatement(String version, Statement statement){
        findPolicy(version)
                .statements()
                .put(statement.sid(), statement);
    }


}
