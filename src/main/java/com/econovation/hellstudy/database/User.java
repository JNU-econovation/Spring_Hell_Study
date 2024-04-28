package com.econovation.hellstudy.database;

import com.econovation.hellstudy.user.application.model.UserModel;

/**
 *
 * @param userName : 유저 이름
 * @param loginId : login ID
 * @param password : 비밀번호
 */
public record User(String userName, String loginId, String password){

    public static User from(UserModel model){
        return new User(model.userName(), model.loginId(), model.password());
    }
}
