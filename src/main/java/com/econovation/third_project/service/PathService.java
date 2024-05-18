package com.econovation.third_project.service;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.Path;
import com.econovation.third_project.dto.ApplicantNumberInPath;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PathService {
    private final Database db;

    public List<ApplicantNumberInPath> getApplicantNumberEachPath(){
        return db.getAllPath().stream()
                .collect(Collectors.groupingBy(Path::getSupportPath, Collectors.counting()))
                .entrySet().stream()
                .map(entry->new ApplicantNumberInPath(entry.getKey().getEntryPathName(), entry.getValue().intValue()))
                .toList();
    }

}
