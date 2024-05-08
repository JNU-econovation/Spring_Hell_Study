package com.econovation.hellstudy.user.application.model;


public record UserModel(Long userId, String loginId, String password, String userName) {

    public UserModel(Long userId, String loginId, String password, String userName){
        this.userId = userId;
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
    }
}
