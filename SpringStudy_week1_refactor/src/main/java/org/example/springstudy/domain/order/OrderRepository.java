package org.example.springstudy.domain.order;

import org.example.springstudy.domain.user.UserBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    public List<Order> findAllByUser(UserBaseEntity userBaseEntity);
}
