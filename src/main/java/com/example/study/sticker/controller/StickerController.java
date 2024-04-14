package com.example.study.sticker.controller;

import com.example.study.sticker.dto.AddStickerRequest;
import com.example.study.sticker.dto.BuyStickerRequest;
import com.example.study.sticker.dto.GetStickerRequest;
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

    @PostMapping("/sticker")
    public ResponseEntity<Void> add(@RequestBody AddStickerRequest addStickerRequest){
        stickerService.add(addStickerRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/sticker")
    public ResponseEntity<Long> getCount(GetStickerRequest getStickerRequest){
        Long count = stickerService.get(getStickerRequest);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @PatchMapping("/sticker")
    public ResponseEntity<Void> buy(@RequestBody BuyStickerRequest buyStickerRequest){
        stickerService.buy(buyStickerRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
