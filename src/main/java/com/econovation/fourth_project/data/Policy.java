package com.econovation.fourth_project.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@RequiredArgsConstructor
@Getter
public class Policy {

    private final OptionalTopLevelElements optionalTopLevelElements;

    private final Statement[] statement;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return Objects.equals(optionalTopLevelElements, policy.optionalTopLevelElements) && Objects.deepEquals(statement, policy.statement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(optionalTopLevelElements, Arrays.hashCode(statement));
    }
}
