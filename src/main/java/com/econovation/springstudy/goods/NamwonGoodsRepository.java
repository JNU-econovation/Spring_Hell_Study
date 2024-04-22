package com.econovation.springstudy.goods;

import java.util.*;

public class NamwonGoodsRepository implements GoodsRepository{
    private static Map<Long, BaseGoods> store = new HashMap<>();
    private static Set<Long> usedIds = new HashSet<>();

    @Override
    public void save(BaseGoods goods) {
        Long id = goods.getId();
        if(usedIds.contains(id)){
            throw new IllegalArgumentException("이미 사용된 ID입니다: " + id);
        }
        store.put(goods.getId(),goods);
        usedIds.add(id);
    }

    @Override
    public BaseGoods findById(Long id) {
        return store.get(id);
    }

    @Override
    public int getStock(Long id) {
        return store.get(id).getStock();
    }

    public List<BaseGoods> findAll(){
        return new ArrayList<>(store.values());
    }
}
