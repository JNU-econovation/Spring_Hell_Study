package com.example.springstudy.store.application.model;

import com.example.springstudy.common.support.AbstractModel;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class StickerModel implements AbstractModel {

    private Long stickerId;
    private int stickerStock;
    private int stickerPrice;

    public StickerModel update(StickerModel requestModel) {
        stickerStock = requestModel.getStickerStock();
        stickerPrice = requestModel.stickerPrice;

        return this;
    }

}
