package com.econovation.third_project.domains.registration.service;

import com.econovation.third_project.database.Registration;
import com.econovation.third_project.domains.registration.adaptor.RegistrationAdaptor;
import com.econovation.third_project.dto.PrioritySumDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class GetPrioritySumUseCase {
    private final RegistrationAdaptor adaptor;

    /**
     * 희망 분야 합계 (1순위, 2순위)
     */
    public PrioritySumDto execute() {
        Collection<Registration> registrations = adaptor.findAllRegistration();
        Map<String,Long> firstPriority = registrations.stream().collect(
                Collectors.groupingBy(Registration::getFirstPriority, Collectors.counting())
        );
        Map<String,Long> secondPriority = registrations.stream().collect(
                Collectors.groupingBy(Registration::getSecondPriority, Collectors.counting())
        );
        return new PrioritySumDto(firstPriority, secondPriority);
    }
}
