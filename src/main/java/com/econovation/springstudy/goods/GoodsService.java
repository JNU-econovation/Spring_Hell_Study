package com.econovation.springstudy.goods;

public interface GoodsService {
    void createGoods(BaseGoods goods); // 상품 생성

    BaseGoods findGoodsById(Long id); // 상품 아이디로 검색

    int getGoodsStock(Long id); // 해당 상품의 재고 확인

}
