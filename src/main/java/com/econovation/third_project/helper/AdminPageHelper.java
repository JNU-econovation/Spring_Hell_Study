package com.econovation.third_project.helper;

import com.econovation.third_project.domains.desiredtime.GetDesiredTimeUseCase;
import com.econovation.third_project.domains.path.service.GetPathSumUseCase;
import com.econovation.third_project.domains.personalinfor.service.GetPersonalInfoUseCase;
import com.econovation.third_project.domains.registration.service.GetApplicantSumUseCase;
import com.econovation.third_project.domains.registration.service.GetPrioritySumUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AdminPageHelper {
    private final GetApplicantSumUseCase getApplicantSumUseCase;
    private final GetPathSumUseCase getPathSumUseCase;
    private final GetPersonalInfoUseCase getPersonalInfoUseCase;
    private final GetPrioritySumUseCase getPrioritySumUseCase;
    private final GetDesiredTimeUseCase getDesiredTimeUseCase;

    private Map<String, Object> response = new HashMap<>();

    /**
     * 요청에 따른 응답 설정
     * @param requestInfos
     * @return
     */
    public List<Map<String,Object>> setResponse(List<String> requestInfos) {
        return requestInfos.stream()
                .map(req -> {
                    checkRequestInfo(req);
                    return response;
                })
                .toList();
    }

    private void checkRequestInfo(String requestInfo) {
        switch (requestInfo) {
            case "Applicant":
                response.put("ApplicantSum", getApplicantSumUseCase.execute());
                break;
            case "Path":
                response.put("PathSum", getPathSumUseCase.execute());
                break;
            case "PersonalInfo":
                response.put("PersonalInfoSum", getPersonalInfoUseCase.execute());
                break;
            case "Priority":
                response.put("PrioritySum", getPrioritySumUseCase.execute());
                break;
            case "DesiredTime":
                response.put("DesiredTimeSum", getDesiredTimeUseCase.execute());
                break;
            default:
                throw new IllegalArgumentException("Invalid request info");
        }
    }
}
