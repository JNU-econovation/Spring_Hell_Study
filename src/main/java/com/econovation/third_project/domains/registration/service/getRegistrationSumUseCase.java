package com.econovation.third_project.domains.registration.service;

import com.econovation.third_project.database.Registration;
import com.econovation.third_project.domains.registration.adaptor.RegistrationAdaptor;
import com.econovation.third_project.domains.registration.domain.HopeField;
import com.econovation.third_project.dto.request.GetAdminPageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class getRegistrationSumUseCase {
    private final RegistrationAdaptor adaptor;

    // (현 지원 기수의) 지원자 누저 합계
    public int getRegistrationSum(GetAdminPageRequest request) {
        return adaptor.findByCardinal(request.cardinal()).size();
    }

    /**
     * 희망 분야 합계 (1순위, 2순위)
     * 이걸 stream 으로 처리해야할까? 아니면 for-each로 해결해야할까?
     * 사실... stream.filter.sum 으로 다 때려박으면 해결될 문제이긴 하지만... 다른 방법이 없을까?
     */
    public long getFirstHopeSum(GetAdminPageRequest request) {
        int web1, app1, ai1, game1, Iot1, arVr1 = 0;
        List<Registration> registrations = adaptor.findByCardinal(request.cardinal());
        for (Registration reg : registrations) {

        }

    }

    private void circulateFirstHopeSum(Registration reg, int web, int app, int ai, int game, int IoT, int arVr) {
        // if문으로 처리시 depth가 너무 길어지는데....
        // 이러면 분야가 추가될 때 너무 많은 코드 수정이 일어나는데
        String firstPriority = reg.getFirstPriority();
        if(firstPriority.equals(HopeField.WEB.name()))
            web++;
        else if(firstPriority.equals(HopeField.APP.name()))
            app++;
        else if(firstPriority.equals(HopeField.AI.name()))
            ai++;
        else if(firstPriority.equals(HopeField.IoT.name()))
            IoT++;
        else
            arVr++;
    }


    private void circulateSecondHopeSum(Registration reg, int web, int app, int ai, int game, int IoT, int arVr) {
        String secondPriority = reg.getSecondPriority();
        if(secondPriority.equals(HopeField.WEB.name()))
            web++;
        else if(secondPriority.equals(HopeField.APP.name()))
            app++;
        else if(secondPriority.equals(HopeField.AI.name()))
            ai++;
        else if(secondPriority.equals(HopeField.IoT.name()))
            IoT++;
        else
            arVr++;
    }
}
