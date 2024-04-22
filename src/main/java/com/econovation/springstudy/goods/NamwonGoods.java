package com.econovation.springstudy.goods;

public class NamwonGoods implements BaseGoods{
    private Long id; // 상품의 아이디
    private String name; // 상품의 이름
    private int price; // 상품의 가격 -> 발주시 가격
    private int stock; // 상품의 재고
    private GoodsRank goodsRank; // 등급


    // 생성자를 통해 스티커 생성
    public NamwonGoods(Long id,String name, int price,int stock,GoodsRank goodsRank){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = goodsRank.getQuantity();
        this.goodsRank = goodsRank;
    }

    @Override
    public Long getId(){return id;}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public GoodsRank getGoodsRank() {
        return goodsRank;
    }

    // 추가 재고 필요시 호출할 메서드
    @Override
    public void setStock(int stock) {
        this.stock = stock;
    }
}

// 우선 생성될 name
//                "남원 두마리 양념치킨 스티커"
//                goodsNames.put(2L,"남원 스타벅스 창립 기념 스티커");
//                goodsNames.put(3L,"남원시 인구 75000명 달성 기념 스티커");
//                goodsNames.put(4L,"남원시 정당 선호 조사 기념 스티커");
//                goodsNames.put(5L,"남원 양림단지 붕어 단체 사망 기념 스티커");
//                goodsNames.put(6L,"남원 지리산 애기봉 완봉 스티커");