package com.econovation.hellstudy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invite")
public class InviteController {
    @PostMapping("/sending")
    public void sendInvite(){

    }
    @PostMapping("/acceptation")
    public void acceptInvite(){

    }
    @PostMapping("/rejection")
    public void rejectInvite(){

    }
}
