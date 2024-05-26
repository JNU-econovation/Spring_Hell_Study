package com.econovation.fourth_project.policy.domain;

import lombok.Getter;

import java.util.Map;
@Getter
public class Statement {
    private String sid;
    private Effect effect;
    private Map<String,String> action;
    private Map<String,String> notAction;
    private String Resource;
}
