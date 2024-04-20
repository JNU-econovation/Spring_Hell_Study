package org.example.springstudy.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderGoodsRepository extends JpaRepository<OrderGoods, Long> {
}
