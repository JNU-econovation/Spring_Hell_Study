package org.example.springstudy.domain.order;

import jakarta.persistence.*;
import lombok.*;
import org.example.springstudy.domain.user.UserBaseEntity;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private UserBaseEntity user;

    @OneToMany(mappedBy = "order")
    private List<OrderGoods> orderGoodsList = new ArrayList<>();
    @Builder
    public Order(UserBaseEntity user, List<OrderGoods> orderGoodsList) {
        this.user = user;
        user.getOrders().add(this);

        for (OrderGoods orderGoods : orderGoodsList){
            this.orderGoodsList.add(orderGoods);
            orderGoods.setOrder(this);
        }
    }
}
