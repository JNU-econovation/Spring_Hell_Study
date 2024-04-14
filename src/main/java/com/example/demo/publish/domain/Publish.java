package com.example.demo.publish.domain;

import com.example.demo.sticker.domain.Sticker;
import com.example.demo.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import java.util.List;
@Entity
@NoArgsConstructor
@Getter
public class Publish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String stickerName;
    @ManyToOne
    private User user;
    private Integer quantity;

    private Integer price;

    public Publish(User user, Integer quantity, String stickerName, Integer price) {
        this.user = user;
        this.quantity = quantity;
        this.stickerName = stickerName;
        this.price = price;
    }


}
