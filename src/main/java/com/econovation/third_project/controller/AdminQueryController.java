package com.econovation.third_project.controller;

import com.econovation.third_project.service.DesiredTimeService;
import com.econovation.third_project.service.PathService;
import com.econovation.third_project.service.PersonalInformationService;
import com.econovation.third_project.service.RegistrationService;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;
import static java.util.stream.Collectors.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminQueryController {
    private final RegistrationService registrationService;
    private final PathService pathService;
    private final PersonalInformationService personalInformationService;
    private final DesiredTimeService desiredTimeService;


    //모든 데이터 한 번에 반환
    @GetMapping("/applicants")
    public ResponseEntity<Map<String, List<?>>> getApplicantsInfo(){
        return ResponseEntity.ok().body(Map.of(
                "job", registrationService.getApplicantNumbersEachJob(),
                "field", registrationService.getApplicantNumberEachField(),
                "major", personalInformationService.getApplicantNumberEachMajor(),
                "path", pathService.getApplicantNumberEachPath(),
                "desired_time", desiredTimeService.getApplicantNumberEachTime()
        ));
    }

    //동적 응답 + 병렬 스트림
    @GetMapping("/applicants/parallel")
    public ResponseEntity<Map<String, List<?>>> getApplicantsInfo(@RequestBody List<String> fields){
        Map<String, Supplier<List<?>>> services = Map.of(
                "job", registrationService::getApplicantNumbersEachJob,
                "field", registrationService::getApplicantNumberEachField,
                "major", personalInformationService::getApplicantNumberEachMajor,
                "path", pathService::getApplicantNumberEachPath,
                "desired_time", desiredTimeService::getApplicantNumberEachTime
        );
        Map<String, List<?>> result = fields.stream().parallel()
                .filter(services::containsKey)
                .collect(toMap(
                                Function.identity(),
                                requestField-> services.get(requestField).get()
                        )
                );

        return ResponseEntity.ok().body(result);
    }

    //동적 응답 + async
    @GetMapping("/applicants/async")
    public ResponseEntity<Map<String, List<?>>> getApplicantsInfoAsync(@RequestBody List<String> fields){
        Map<String, Supplier<List<?>>> services = Map.of(
                "job", registrationService::getApplicantNumbersEachJob,
                "field", registrationService::getApplicantNumberEachField,
                "major", personalInformationService::getApplicantNumberEachMajor,
                "path", pathService::getApplicantNumberEachPath,
                "desired_time", desiredTimeService::getApplicantNumberEachTime
        );

        Map<String, CompletableFuture<List<?>>> futures = fields.stream()
                .collect(toMap(
                        Function.identity(),
                        field -> {
                            Supplier<List<?>> service = services.get(field);
                            if (service == null)
                                throw new IllegalArgumentException();
                            return CompletableFuture.supplyAsync(service);
                        }
                ));

        CompletableFuture<Map<String, List<?>>> result = CompletableFuture.allOf(
                futures.values().toArray(CompletableFuture[]::new)
        ).thenApply(v ->
                fields.stream()
                    .collect(toMap(Function.identity(), field-> futures.get(field).join()))
        );

        return ResponseEntity.ok().body(result.join());
    }

    //병렬 스트림 + async

}
