package com.econovation.fourth_project.common;

public enum Method {
    GET("GET"),
    PUT("PUT"),
    POST("POST"),
    DELETE("DELETE"),
    ALL("*");

    private String method;

    Method(String method){
        this.method = method;
    }

}
