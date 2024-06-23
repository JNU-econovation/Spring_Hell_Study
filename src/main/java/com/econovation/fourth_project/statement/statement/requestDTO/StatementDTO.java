package com.econovation.fourth_project.statement.statement.requestDTO;

import com.econovation.fourth_project.statement.Principal.requestDTO.NotPrincipalDTO;
import com.econovation.fourth_project.statement.Principal.requestDTO.PrincipalDTO;

public class StatementDTO {
    private String sid;
    private String effect;
    private PrincipalDTO principalDTO;
    private NotPrincipalDTO notPrincipalDTO;
    private String action;
    private String notAction;
    private String resource;
    private String notResource;


}
