package com.econovation.third_project.dto;

public record HopeSum(long firstHopeSum, long secondHopeSum, String hopeField) {
    public static HopeSum of(long firstHopeSum, long secondHopeSum, String hopeField) {
        return new HopeSum(firstHopeSum, secondHopeSum, hopeField);
    }
}
