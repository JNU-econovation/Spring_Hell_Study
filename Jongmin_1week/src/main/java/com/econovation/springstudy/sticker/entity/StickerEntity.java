package com.econovation.springstudy.sticker.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class StickerEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "all_remain")
    private Long remain;

    @Column(name = "official_purchasable")
    private Long officialPurchasable;

    @Column(name = "non-official_purchasable")
    private Long nonOfficialPurchasable;

    @Column(name = "price")
    private Long price;

}
