package com.econovation.fourth_project.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@RequiredArgsConstructor
@Getter
public class Statement {

    private final String Sid;

    private final String Effect;

    private final Object[] Principal;

    private final String Action;

    private final String Resource;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement = (Statement) o;
        return Objects.equals(Sid, statement.Sid) && Objects.equals(Effect, statement.Effect) && Objects.deepEquals(Principal, statement.Principal) && Objects.equals(Action, statement.Action) && Objects.equals(Resource, statement.Resource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Sid, Effect, Arrays.hashCode(Principal), Action, Resource);
    }
}
