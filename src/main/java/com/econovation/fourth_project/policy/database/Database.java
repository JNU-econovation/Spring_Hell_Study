package com.econovation.fourth_project.policy.database;

import com.econovation.fourth_project.policy.common.AutoIncrement;
import com.econovation.fourth_project.policy.domain.Policy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Component
@RequiredArgsConstructor
public class Database {
    private final AutoIncrement autoIncrement;
    private Map<Long, Policy> policyTb = new ConcurrentHashMap<>();

    public Policy savePolicy(Policy policy) {
        Long id = autoIncrement.autoIncrement();
        policyTb.put(id,policy);
        policy.setId(id);
        return policy;
    }

    public List<Policy> findByResource(String resource) {
       return policyTb.values().stream()
                .filter(policy -> policy.getStatement().getResource().split(":").(resource))
                .toList();
    }
}
