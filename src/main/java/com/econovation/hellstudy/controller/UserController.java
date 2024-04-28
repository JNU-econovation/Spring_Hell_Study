package com.econovation.hellstudy.controller;

import com.econovation.hellstudy.DTO.BlockUserReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/block")
    public void blockUser(@RequestBody BlockUserReq blockUserReq){

    }
}
