package com.econovation.hellstudy.controller;

import com.econovation.hellstudy.DTO.AcceptInviteReq;
import com.econovation.hellstudy.DTO.InviteUserReq;
import com.econovation.hellstudy.DTO.RejectInviteReq;
import com.econovation.hellstudy.service.InviteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invite")
public class InviteController {
    private final InviteService inviteService;

    public InviteController(InviteService inviteService) {
        this.inviteService = inviteService;
    }

    @PostMapping("/sending")
    public void inviteUser(@RequestBody InviteUserReq inviteUserReq){
        inviteService.inviteUser(inviteUserReq);
    }
    @PostMapping("/acceptation")
    public void acceptInvite(@RequestBody AcceptInviteReq acceptInviteReq){
        inviteService.acceptInvite(acceptInviteReq);
    }
    @PostMapping("/rejection")
    public void rejectInvite(@RequestBody RejectInviteReq rejectInviteReq){
        inviteService.rejectInvite(rejectInviteReq);
    }
}
