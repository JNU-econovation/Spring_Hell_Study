package com.econovation.springstudy.goods;

public class GoodsServiceImpl implements GoodsService{
    private final GoodsRepository goodsRepository = new NamwonGoodsRepository();
    @Override
    public void createGoods(BaseGoods goods) {
        goodsRepository.save(goods);
    }

    @Override
    public BaseGoods findGoodsById(Long id) {
        return goodsRepository.findById(id);
    }

    @Override
    public int getGoodsStock(Long id) {
        return goodsRepository.getStock(id);
    }
}
