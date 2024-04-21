package com.econovation.springstudy.sticker.application.support;

import com.econovation.springstudy.sticker.application.model.StickerModel;

@FunctionalInterface
public interface PurchasableCntGetter {

    public <T extends StickerModel> Long getPurchasable(T t);

}
