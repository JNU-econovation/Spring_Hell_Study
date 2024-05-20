package com.econovation.third_project.domains.path.service;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class GetPathSumUseCase {
    private final Database database;

    public Map<String, Long> execute() {
        return database.findAllPath().stream().collect(
               groupingBy(Path::getSupportPath, Collectors.counting())
        );
    }
}
