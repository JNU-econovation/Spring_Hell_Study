package com.example.demo.common.aop;

import com.example.demo.common.annotation.LimitQuantity;
import com.example.demo.common.message.StaticMessage;
import com.example.demo.purchase.domain.Purchase;
import com.example.demo.purchase.repsoitory.PurchaseRepository;
import com.example.demo.sticker.domain.Sticker;
import com.example.demo.sticker.repository.StickerRepository;
import com.example.demo.user.domain.UserRole;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@RequiredArgsConstructor
public class GovernmentQuantityAspect {
    private final StickerRepository stickerRepository;
    private final PurchaseRepository purchaseRepository;

    @Around("@annotation(com.example.demo.common.annotation.LimitQuantity)")
    public Object process(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        LimitQuantity limitQuantity = methodSignature.getMethod().getAnnotation(LimitQuantity.class);
        UserRole userRole = limitQuantity.userRole();
        canPurchaseStickerForGov(userRole);
        return proceedingJoinPoint.proceed();
    }

    private void canPurchaseStickerForGov(UserRole userRole) {
        if(userRole.equals(UserRole.GOVERNMENT)) {
            List<Sticker> stickers = stickerRepository.findAll();
            List<Purchase> govPurchases = purchaseRepository.findByUserRole(UserRole.GOVERNMENT);
            int initialStockAmount = stickers.stream().mapToInt(Sticker::getInitialStock).sum();
            int governmentAmount = govPurchases.stream().mapToInt(Purchase::getQuantity).sum();
            int thirtyPerAmount = (initialStockAmount * 3) / 10;

            if(thirtyPerAmount > governmentAmount)
                throw new IllegalArgumentException(StaticMessage.GOV_CANNOT_PURCHASE_OVER_THIRTY);
        }
    }
}
