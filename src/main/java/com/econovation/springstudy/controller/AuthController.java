package com.econovation.springstudy.controller;

import com.econovation.springstudy.dto.auth.LoginReq;
import com.econovation.springstudy.dto.auth.SignupReq;
import com.econovation.springstudy.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginReq loginReq){
        authService.login(loginReq);
        return "로그인 성공";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody SignupReq signupReq){
        authService.signup(signupReq);
        return "회원가입 성공";
    }

}
