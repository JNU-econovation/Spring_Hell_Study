package com.econovation.third_project.domains.desiredtime;

import com.econovation.third_project.database.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetDesiredTimeUseCase {
    private final Database database;

    /**
     * 면접 희망 시간
     * ex) (0,1) → 4명, (2,5) → 2명, (3,4) → 0명
     */
    public Map<List<Integer>, Long> execute() {
        return database.findAllDesiredTime().stream()
                .flatMap(desiredTime -> desiredTime.getDesiredTime().stream())
                .map(array -> Arrays.stream(array).boxed().collect(Collectors.toList()))
                .collect(
                        Collectors.groupingBy(
                                list -> list,
                                Collectors.counting()
                        )
                );
    }
}
