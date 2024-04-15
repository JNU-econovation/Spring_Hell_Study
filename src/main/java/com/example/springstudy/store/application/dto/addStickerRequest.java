package com.example.springstudy.store.application.dto;

import com.example.springstudy.common.support.dto.AbstractDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class addStickerRequest implements AbstractDto {
    private String name;
}
