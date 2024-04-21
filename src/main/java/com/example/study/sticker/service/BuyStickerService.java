package com.example.study.sticker.service;

import com.example.study.city.dto.AddStickerRequest;
import com.example.study.city.dto.StickerDTO;
import com.example.study.city.service.CityService;
import com.example.study.sticker.domain.Sticker;
import com.example.study.sticker.repository.StickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuyStickerService {

    private final StickerRepository stickerRepository;
    private final CityService cityService;

    public void execute(String cityName, AddStickerRequest addStickerRequest) {
        cityService.pay(cityName, addStickerRequest);

        List<String> stickerNames = cityService.findStickers(cityName);

        List<String> newStickerNames = new ArrayList<>(stickerNames);

        for(StickerDTO stickerDTO : addStickerRequest.stickerDTOs()) {
            if(stickerNames.contains(stickerDTO.name())){
                Sticker sticker = stickerRepository.find(stickerDTO.name()).orElseThrow(NullPointerException::new);
                Sticker updatedSticker = sticker.plusStock(stickerDTO.count());
                stickerRepository.save(updatedSticker);
            }else{
                Sticker sticker = Sticker.createSticker(stickerDTO.name(), stickerDTO.count());
                stickerRepository.save(sticker);
                newStickerNames.add(stickerDTO.name());
            }
        }

        cityService.updateCityStickers(cityName, newStickerNames);
    }

}
