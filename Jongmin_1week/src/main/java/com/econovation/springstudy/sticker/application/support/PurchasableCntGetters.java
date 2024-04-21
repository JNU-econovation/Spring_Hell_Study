package com.econovation.springstudy.sticker.application.support;

import com.econovation.springstudy.sticker.application.model.StickerModel;
import jakarta.persistence.Column;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
public enum PurchasableCntGetters {

    ALL_PURCHASABLE(StickerModel::getRemain),
    OFFICIAL_PURCHASABLE(StickerModel::getOfficialPurchasable),
    NON_OPFFICIAL_PURCHASABLE(StickerModel::getNonOfficialPurchasable);

    private PurchasableCntGetter getter;

    PurchasableCntGetters(PurchasableCntGetter getter) { this.getter = getter; }

}
