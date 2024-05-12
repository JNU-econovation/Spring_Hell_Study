package com.econovation.third_project.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public record HopeField(List<HopeSum> hopeSums) {
}
