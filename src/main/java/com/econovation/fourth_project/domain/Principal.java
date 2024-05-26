package com.econovation.fourth_project.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class Principal {
    private List<String> subjects;
    private Boolean isAll;

    private Boolean isExcept;

}
