package com.econovation.third_project.domain;

public enum HopeField {

    개발자,기획자,디자이너;

    public Boolean isProgrammer(HopeField hopeField){
        return hopeField.name().equals(HopeField.개발자);
    }
}
