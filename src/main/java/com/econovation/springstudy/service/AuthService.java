package com.econovation.springstudy.service;

import com.econovation.springstudy.dto.auth.LoginReq;
import com.econovation.springstudy.dto.auth.SignupReq;
import com.econovation.springstudy.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    @Transactional
    public void login(LoginReq loginReq){
        String userId = loginReq.getUserId();
        String password = loginReq.getPassword();

        User user = userService.getUserOrThrow(userId);
        //디코딩 로직 추가하기
        if (!user.getPassword().equals(password))
            throw new IllegalArgumentException("비밀번호가 맞지 않아요");
    }

    @Transactional
    public void signup(SignupReq signupReq){

        String password = signupReq.getPassword();
        //--인코딩 로직--

        userService.createUser(signupReq.getUserId(), password);
        //TODO: CreateUserDTO
    }





}
