package com.econovation.springstudy.goods;

import java.util.HashMap;
import java.util.Map;

public class NamwonGoodsRepository implements GoodsRepository{
    private static Map<Long, BaseGoods> store = new HashMap<>();

    @Override
    public void save(BaseGoods goods) {
        store.put(goods.getId(),goods);
    }

    @Override
    public BaseGoods findById(Long id) {
        return store.get(id);
    }

    @Override
    public int getStock(Long id) {
        return store.get(id).getStock();
    }


}
