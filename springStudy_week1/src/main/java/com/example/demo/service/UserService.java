package com.example.demo.service;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public void join(String phoneNumber, int countGoods, Role role){
//        User user = User.builder()
//                .phoneNumber(phoneNumber)
//                .countGoods(countGoods)
//                .role(role)
//                .build();
//        userRepository.save(user);
//    }

}
