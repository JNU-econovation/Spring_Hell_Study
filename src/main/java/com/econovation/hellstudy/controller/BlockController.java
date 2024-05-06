package com.econovation.hellstudy.controller;

import com.econovation.hellstudy.DTO.block.BlockUserReq;
import com.econovation.hellstudy.service.BlockService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class BlockController {
    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @PostMapping("/block")
    public void blockUser(@RequestBody BlockUserReq blockUserReq){
        blockService.blockUser(blockUserReq);
    }
}
