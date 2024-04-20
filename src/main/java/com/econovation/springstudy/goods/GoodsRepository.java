package com.econovation.springstudy.goods;

public interface GoodsRepository {
    void save(BaseGoods goods); // 상품 저장

    BaseGoods findById(Long id); // 상품 Id로 검색

    int getStock(Long id); // 상품 Id로 해당 상품의 재고 반환
}
