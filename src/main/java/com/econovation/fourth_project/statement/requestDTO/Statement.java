package com.econovation.fourth_project.statement.requestDTO;

import com.econovation.fourth_project.statement.requestDTO.Action.Action;
import com.econovation.fourth_project.statement.requestDTO.Effect.Effect;
import com.econovation.fourth_project.statement.requestDTO.Principal.Principal;
import com.econovation.fourth_project.statement.requestDTO.Resouce.Resource;
import com.econovation.fourth_project.statement.requestDTO.Sid.Sid;

public class Statement {
    private Sid sid;
    private Effect effect;
    private Principal principal;

    private Principal notPrincipal;
    private Action action;
    private Action notAction;
    private Resource resource;
    private Resource notResource;


}
