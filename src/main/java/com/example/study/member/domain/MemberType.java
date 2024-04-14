package com.example.study.member.domain;

public enum MemberType {

    PUBLIC_OFFICIAL, NORMAL;

    public static Boolean isPublicOfficial(MemberType type){
        if(type.equals(MemberType.PUBLIC_OFFICIAL)){
            return true;
        }
        return false;
    }

}
