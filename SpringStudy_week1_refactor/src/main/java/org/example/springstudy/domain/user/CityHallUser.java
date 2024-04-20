package org.example.springstudy.domain.user;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
@Getter
// 여러 시청들이 있을 수 있다고 생각해서 cityhalluser도 entity
public class CityHallUser extends UserBaseEntity {
    private int budget;

    public void Order(int totalPrice){
        this.budget -= totalPrice;
    }

    public void Sell(int totalPrice){
        this.budget += totalPrice;
    }
}
