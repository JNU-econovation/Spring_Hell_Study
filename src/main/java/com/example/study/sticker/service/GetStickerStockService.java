package com.example.study.sticker.service;

import com.example.study.city.dto.FindStickersResponse;
import com.example.study.city.dto.StickerDTO;
import com.example.study.city.service.CityService;
import com.example.study.sticker.domain.Sticker;
import com.example.study.sticker.repository.StickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetStickerStockService {

    private final StickerRepository stickerRepository;
    private final CityService cityService;

    public FindStickersResponse execute(String cityName){
        List<String> stickerNames = cityService.findStickers(cityName);
        List<Sticker> stickers = stickerRepository.findAll(stickerNames);
        List<StickerDTO> stickerDTOS = stickers.stream()
                .map(sticker -> new StickerDTO(sticker.getName(), sticker.getStock()))
                .collect(Collectors.toList());
        return new FindStickersResponse(stickerDTOS);
    }

}
