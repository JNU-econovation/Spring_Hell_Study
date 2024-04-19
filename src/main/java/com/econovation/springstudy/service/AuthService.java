package com.econovation.springstudy.service;

import com.econovation.springstudy.config.enums.UserRole;
import com.econovation.springstudy.dto.auth.LoginReq;
import com.econovation.springstudy.dto.auth.SignupReq;
import com.econovation.springstudy.entity.User;
import com.econovation.springstudy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void login(LoginReq loginReq){
        String userId = loginReq.getUserId();
        String password = loginReq.getPassword();

        User user = getUserOrThrow(userId);
        //디코딩 로직 추가하기
        if (!user.getPassword().equals(password))
            throw new IllegalArgumentException("비밀번호가 맞지 않아요");
    }

    public void signup(SignupReq signupReq){
        String userId = signupReq.getUserId();
        String password = signupReq.getPassword();

        //인코딩 로직 추가하기
        User user = new User(userId, password, UserRole.OFFICIAL);
        userRepository.save(user);
    }

    public Optional<User> getUser(String userId){
        return userRepository.findByUserId(userId);
    }
    public User getUserOrThrow(String userId){
        return userRepository.findByUserId(userId).orElseThrow(()->new IllegalArgumentException("그런 유저 없어요"));
    }



}
