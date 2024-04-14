package com.econovation.springstudy.goods;

public class Goods1 implements BaseGoods{
    private int stock = 0;


    @Override
    public void createGoods(int num) {
        this.stock += num;
    }

    @Override
    public int countStock(BaseGoods b) {
        return this.stock;
    }
}
