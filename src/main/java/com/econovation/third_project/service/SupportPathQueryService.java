package com.econovation.third_project.service;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.Path;
import com.econovation.third_project.domain.SupportPath;
import com.econovation.third_project.dto.PathDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class SupportPathQueryService {

    private final Database database;

    public List<PathDTO> execute(){
        List<Path> allPath = database.getAllPath();
        Map<SupportPath, List<Path>> pathListMap = allPath.stream().collect(groupingBy(Path::getSupportPath));
        return pathListMap.keySet().stream()
                .map(path -> PathDTO.of(path.name(),pathListMap.get(path).size())).toList();
    }
}
