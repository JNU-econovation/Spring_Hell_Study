package com.econovation.fourth_project.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
public class OptionalTopLevelElements {

    private final String version;

    /** 자동 생성 */
    private final String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OptionalTopLevelElements that = (OptionalTopLevelElements) o;
        return Objects.equals(version, that.version) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, id);
    }
}