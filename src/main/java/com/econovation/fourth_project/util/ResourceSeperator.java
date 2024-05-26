package com.econovation.fourth_project.util;

public class ResourceSeperator {

    public static String seperateTarget(String resourceAction){
        return resourceAction.split(":")[0];
    }

    public static String seperateAction(String resourceAction){
        return resourceAction.split(":")[1];
    }

}
