package com.econovation.fourth_project.domain;

import com.econovation.fourth_project.util.ResourceSeperator;
import lombok.Getter;

@Getter
public class Statement {

    private String sid;
    private Effect effect;
    private Principal principal;
    private Action action;
    private String resource;

    public String getTargetOfResource(){
        return ResourceSeperator.seperateTarget(this.resource);
    }

    public String getActionOfResource(){
        return ResourceSeperator.seperateAction(this.resource);
    }

    /**
     * isExcept가 false이고, isAll이 true인 s
     */


}
