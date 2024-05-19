package com.econovation.third_project.database;

public enum PathType {
    POSTER("홍보 포스터"),
    ANNOUNCEMENT("학과 공지사항"),
    INTRODUCTION("지인 소개"),
    INSTAGRAM("인스타그램"),
    EVERYTIME("에브리타임"),
    ETIC("기타");

    final private String type;
    public String getType(){
        return type;
    }
    private PathType(String type){
        this.type = type;
    }
}
