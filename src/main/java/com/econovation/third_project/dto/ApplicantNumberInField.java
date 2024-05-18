package com.econovation.third_project.dto;

public record ApplicantNumberInField(String fieldName, int firstNumber, int secondNumber) implements Comparable<ApplicantNumberInField>{
    @Override
    public int compareTo(ApplicantNumberInField o) {
        return (this.firstNumber+this.secondNumber) - (o.firstNumber + o.secondNumber);
    }
}
