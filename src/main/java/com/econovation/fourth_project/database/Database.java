package com.econovation.fourth_project.database;

import com.econovation.fourth_project.domain.Policy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class Database {
    private HashMap<String, Policy> policyHashMap = new HashMap<>();
    // pll, policy

    public Policy findPolicy(String pll){
        return policyHashMap.get(pll);
    }

    public List<Policy> findAll(){
        return policyHashMap.values().stream().toList();
    }

}
