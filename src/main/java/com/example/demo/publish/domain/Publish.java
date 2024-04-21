package com.example.demo.publish.domain;

import com.example.demo.sticker.domain.Sticker;
import com.example.demo.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Entity
@Table(name = "publish")
@NoArgsConstructor
@Getter
public class Publish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String stickerName;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
    private Integer quantity;
    private Integer price;
    // 기본적으로 false, 돈이 임금이 되어 발주 정상적으로 처리되면 true
    private Boolean isConfirmed;

    public Publish(User user, Integer quantity, String stickerName, Integer price) {
        this.user = user;
        this.quantity = quantity;
        this.stickerName = stickerName;
        this.price = price;
        this.isConfirmed = false;
    }

    public void updateIsConfirmed() {
        this.isConfirmed = true;
    }


}
