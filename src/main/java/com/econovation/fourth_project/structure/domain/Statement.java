package com.econovation.fourth_project.structure.domain;

import lombok.Getter;

@Getter
public class Statement {
    private String sid; // 중복 아닌 값
    private String effect; // Allow or Deny
    private String principal; // 보안 주체(사용자, 그룹, 역할 등) 지정
    private String notPrincipal;
    private String action;
    private String resource;

}
