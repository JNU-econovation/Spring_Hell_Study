package com.econovation.springstudy.purchase.application.service;

import com.econovation.springstudy.consumer.model.ConsumerTypes;
import com.econovation.springstudy.purchase.application.dto.request.PurchaseStickerRequest;
import com.econovation.springstudy.purchase.application.dto.response.QueryStickersResponse;
import com.econovation.springstudy.purchase.application.exception.DeniedPurchaseException;
import com.econovation.springstudy.purchase.application.exception.ExceedPurchaseCountException;
import com.econovation.springstudy.purchase.application.exception.InsufficientRemainException;
import com.econovation.springstudy.purchase.application.usecase.PurchaseStickerUsecase;
import com.econovation.springstudy.sticker.application.model.StickerModel;
import com.econovation.springstudy.sticker.application.model.StickerTable;
import com.econovation.springstudy.sticker.application.model.converter.StickerModelConverter;
import com.econovation.springstudy.sticker.application.support.PurchasableCntGetter;
import com.econovation.springstudy.sticker.application.support.PurchasableCntGetters;
import com.econovation.springstudy.sticker.repository.StickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseService implements PurchaseStickerUsecase {

    private final StickerRepository stickerRepository;
    private final StickerModelConverter stickerModelConverter;
    private final StickerTable stickerTable;

    /**
     * PurchasableGetter
     *  공직자와 비공직자 전체가 구매할 수 있는 스티커의 총 수량이 다르므로, 현재 구매할 수 있는 스티커의 수량을
     *  공직자와 비공직자에 맞게 가져오는 람다식
     */
    private final PurchasableCntGetter officialPurchasableGetter = PurchasableCntGetters.OFFICIAL_PURCHASABLE.getGetter();
    private final PurchasableCntGetter nonOfficialPurchasableGetter = PurchasableCntGetters.NON_OPFFICIAL_PURCHASABLE.getGetter();
    private final PurchasableCntGetter allPurchasableGetter = PurchasableCntGetters.ALL_PURCHASABLE.getGetter();

    public QueryStickersResponse purchase(PurchaseStickerRequest request){
        /**
         * 1. 구매 개수 확인
         * 2. 일단 구매 로직 진행
             * a. 공직자인지 확인
             * b. 공직자라면, 공직자용 스티커가 남았는지 확인
             * c. 남아 있다면, 10% 할인
         * 3. 공직자가 아니라면, 일반용 스티커가 남았는지 확인
         */
        List<StickerModel> stickers = isOfficial(request) ? getRandomStickers(request, officialPurchasableGetter) : getRandomStickers(request, nonOfficialPurchasableGetter);

        return QueryStickersResponse.of(stickers, request.getConsumerType());
    }

    private List<StickerModel> getRandomStickers(PurchaseStickerRequest request, PurchasableCntGetter purchasableCntGetter){

        isOrderUnderNine(request);
        isSufficientRemain(request, purchasableCntGetter);

        int stickerLength = request.getCount().intValue();
        List<StickerModel> stickers = new ArrayList<>(stickerLength);

        for(int i=0; i<stickerLength; i++){
            stickers.set(i, getRandomSticker(purchasableCntGetter));
        }

        return stickers;
    }

    private StickerModel getRandomSticker(PurchasableCntGetter purchasableCntGetter){
        /**
         * 스티커가 고르게 선택되기 위해서는, 많이 남은 스티커가 더 잘 뽑혀야 한다.
         */
        Random random = new Random();

        List<StickerModel> models = getStickersAll();

        Long rndStickerNumber= random.nextLong(1,getStickerCntAll(purchasableCntGetter)+1);

        long sum = 0;

        List<Long> list = models.stream()
                .sorted((m1, m2) -> ((int)(m1.getRemain()-m2.getRemain())))
                .map(model -> model.getRemain() + sum)
                .filter(remain -> remain >= rndStickerNumber)
                .toList();

        return models.get(list.size());
    }

    private void isOrderUnderNine(PurchaseStickerRequest request){
        if(request.getCount() > 9) throw new ExceedPurchaseCountException();
    }

    private boolean isOfficial(PurchaseStickerRequest request){
        return request.getConsumerType().equals(ConsumerTypes.OFFICIAL.getConsumerType());
    }

    private void isSufficientRemain(PurchaseStickerRequest request, PurchasableCntGetter getter){
        if(request.getCount() > getStickerCntAll(getter)) throw new InsufficientRemainException();
    }

    private Long getStickerCntAll(PurchasableCntGetter purchasableCntGetter){
        return getStickersAll().stream()
                .map(model -> purchasableCntGetter.getPurchasable(model))
                .collect(Collectors.reducing(0L, (i,m) -> i+m));
    }

    private List<StickerModel> getStickersAll(){
        return stickerRepository.findAll().stream()
                .map(e -> stickerModelConverter.from(e))
                .collect(Collectors.toList());
    }
}
