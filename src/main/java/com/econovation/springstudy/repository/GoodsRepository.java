package com.econovation.springstudy.repository;

import com.econovation.springstudy.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {

}
