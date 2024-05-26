package com.econovation.fourth_project.domain;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.Builder;
import lombok.NonNull;


public record Statement(
                        @NonNull
                        Integer sid,
                        String effect,
                        @NonNull
                        String principal,
                        String notPrincipal,
                        String action,
                        String notAction,
                        String resource) {
    private static final AtomicInteger nextId = new AtomicInteger(0);

    @Builder
    public static Statement of(
            String effect,
            @NonNull String principal,
            String notPrincipal,
            String action,
            String notAction,
            String resource) {
        return new Statement(nextId.getAndIncrement(), effect, principal, notPrincipal, action, notAction, resource);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Statement statement && statement.sid().equals(this.sid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.sid);
    }

    //원래 여기에 validate


}
