package com.example.study.sticker.controller;

import com.example.study.sticker.service.StickerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StickerController {

    private final StickerService stickerService;

    @PatchMapping("/sticker")
    public ResponseEntity<Void> buy(@RequestBody SellStickerRequest sellStickerRequest){
        stickerService.buy(sellStickerRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
