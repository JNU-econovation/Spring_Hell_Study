package com.econovation.third_project.dto;

import com.econovation.third_project.config.Field;
import java.util.Map.Entry;

public record ApplicantNumberInField(String fieldName, int firstNumber, int secondNumber) implements Comparable<ApplicantNumberInField>{
    @Override
    public int compareTo(ApplicantNumberInField o) {
        return (this.firstNumber+this.secondNumber) - (o.firstNumber + o.secondNumber);
    }

    public ApplicantNumberInField(Entry<Field, int[]> entry) {
        this(
                entry.getKey().getFieldName(),
                entry.getValue()[0],
                entry.getValue()[1]
        );
    }
}
