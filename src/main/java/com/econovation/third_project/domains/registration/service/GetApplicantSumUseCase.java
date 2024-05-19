package com.econovation.third_project.domains.registration.service;

import com.econovation.third_project.database.Registration;
import com.econovation.third_project.domains.registration.adaptor.RegistrationAdaptor;
import com.econovation.third_project.dto.PrioritySumDto;
import com.econovation.third_project.dto.request.GetAdminPageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetApplicantSumUseCase {
    private final RegistrationAdaptor adaptor;

    // 지원자 누저 합계
    public int execute() {
        return adaptor.findAllRegistration().size();
    }
}
