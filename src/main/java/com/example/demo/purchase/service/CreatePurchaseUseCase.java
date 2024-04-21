package com.example.demo.purchase.service;

import com.example.demo.common.annotation.LimitQuantity;
import com.example.demo.common.message.StaticMessage;
import com.example.demo.purchase.model.request.CreatePurchaseRequest;
import com.example.demo.purchase.model.response.CreatePurchaseResponse;
import com.example.demo.purchase.repsoitory.PurchaseRepository;
import com.example.demo.sticker.domain.Sticker;
import com.example.demo.sticker.repository.StickerRepository;
import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserRole;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CreatePurchaseUseCase {
    private final PurchaseRepository purchaseRepository;
    private final UserRepository userRepository;
    private final StickerRepository stickerRepository;

    @Transactional
    @LimitQuantity(userRole = UserRole.GOVERNMENT)
    public CreatePurchaseResponse execute(CreatePurchaseRequest request) {
        checkQuantity(request.quantity());
        int totalPrice = 0;
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new IllegalArgumentException(StaticMessage.NOT_FOUND_MEMBER));
        List<Sticker> stickers = stickerRepository.findAll();

        //Sticker 수량이 가장 많은 것을 판매한다 -> 균등하게 랜덤 판매한다
        Sticker randomSticker = stickers.stream().max(Comparator.comparingInt(Sticker::getStock))
                .orElseThrow(() -> new NoSuchElementException(StaticMessage.DOES_NOT_EXIST_STICKER));

        totalPrice = randomSticker.getPrice() * request.quantity();
        totalPrice = sale(user,totalPrice);
        return CreatePurchaseResponse.of(totalPrice, randomSticker.getName(), request.quantity());
    }

    /**
     * 공직자 들에게 10% 할인
     * @param user
     * @param totalPrice
     * @return
     */
    private int sale(User user, int totalPrice) {
        if (user.getUserRole().equals(UserRole.GOVERNMENT))
            totalPrice = (totalPrice * 9) / 10;
        return totalPrice;
    }

    /**
     * CreatePurchaseRequest에서 @Valid 해도 되지만 Validation을 쓰지 않았음.
     * @param quantity
     */
    private void checkQuantity(Integer quantity) {
        if(quantity.intValue() > 8)
            throw new IllegalArgumentException("Quantity must not bigger than 8");
    }

    //TODO: 공직자에게는 스티커 전체 30%만 판매
}
