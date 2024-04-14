package com.econovation.springstudy.printingHouse;

import com.econovation.springstudy.goods.BaseGoods;
import com.econovation.springstudy.goods.Goods1;
import com.econovation.springstudy.goods.Goods2;

public class PrintingHouse {
    int salePrice = 0;
    
    // 생성자 , getter, setter

    BaseGoods bg1 = new Goods1();
    BaseGoods bg2 = new Goods2();
    
    public void produceGoods(int num){
        // Goods 생성 메서드
        bg1.createGoods(num);
        // Goods 구성을 다시 생각해야함.. 이 방식으로는 불가능
    }
}
