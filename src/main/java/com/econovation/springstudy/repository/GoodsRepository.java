package com.econovation.springstudy.repository;

import com.econovation.springstudy.config.enums.GoodsType;
import com.econovation.springstudy.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {
    List<Goods> findAllByGoodsType(GoodsType goodsType);
}
