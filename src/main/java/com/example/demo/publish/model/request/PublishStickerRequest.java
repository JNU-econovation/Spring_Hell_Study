package com.example.demo.publish.model.request;

import com.example.demo.publish.model.PublishDto;

import java.util.List;

public record PublishStickerRequest(List<PublishDto> stickers, Long userId) {
}
