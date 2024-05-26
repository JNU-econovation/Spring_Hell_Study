package com.econovation.fourth_project.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public record Policy(OptionalTopLevelElement optionalTopLevelElement,
                     Map<Integer, Statement> statements){

    public Policy(String version) {
        this(new OptionalTopLevelElement(version, UUID.randomUUID().toString()),  new HashMap<>());
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Policy policy && policy.optionalTopLevelElement.version().equals(this.optionalTopLevelElement.version());
    }

    @Override
    public int hashCode() {
        return this.optionalTopLevelElement.version().hashCode();
    }
}
