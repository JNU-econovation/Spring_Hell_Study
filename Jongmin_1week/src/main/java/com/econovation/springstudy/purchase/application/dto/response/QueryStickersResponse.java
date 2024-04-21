package com.econovation.springstudy.purchase.application.dto.response;

import com.econovation.springstudy.consumer.model.ConsumerDiscountRatio;
import com.econovation.springstudy.consumer.model.ConsumerTypes;
import com.econovation.springstudy.sticker.application.model.StickerModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Builder
public class QueryStickersResponse {

    private final List<QueryStickerResponse> response;

    private final String consumerType;

    private final double totalPrice;

    public static QueryStickersResponse of(List<StickerModel> models, String consumerType){
        return QueryStickersResponse.builder()
                .response(toQueryStickerResponse(models))
                .consumerType(consumerType)
                .totalPrice(getTotalPrice(models, consumerType))
                .build();
    }

    private static List<QueryStickerResponse> toQueryStickerResponse(List<StickerModel> models){
        return models.stream()
                .map(model -> QueryStickerResponse.of(model))
                .collect(Collectors.toList());
    }

    private static double getTotalPrice(List<StickerModel> models, String consumerType){
        if(consumerType.equals(ConsumerTypes.OFFICIAL.getConsumerType()))
            return models.stream()
                    .collect(Collectors.summingLong(StickerModel::getPrice))
                    * ConsumerDiscountRatio.OFFICIAL.getRatio();

        return models.stream()
                .collect(Collectors.summingLong(StickerModel::getPrice))
                .doubleValue();
    }
}
