package com.example.demo.publish.controller;

import com.example.demo.publish.model.request.PublishStickerRequest;
import com.example.demo.publish.model.response.PublishStickerResponse;
import com.example.demo.publish.service.PublishStickerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PublishController {
    private final PublishStickerUseCase publishStickerUseCase;


    @PostMapping("/sticker")
    public ResponseEntity<PublishStickerResponse> publishSticker(@RequestBody PublishStickerRequest request) {
        PublishStickerResponse response = publishStickerUseCase.execute(request);
        return ResponseEntity.ok(response);
    }
}
