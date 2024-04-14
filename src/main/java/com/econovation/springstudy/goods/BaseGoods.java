package com.econovation.springstudy.goods;

public interface BaseGoods {
    abstract void createGoods(int num);
    abstract int countStock(BaseGoods b);
}
