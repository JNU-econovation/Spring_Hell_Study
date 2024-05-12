package com.econovation.third_project.service;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.Registration;
import com.econovation.third_project.domain.HopeField;
import com.econovation.third_project.domain.ProgrammerField;
import com.econovation.third_project.dto.ProgrammerFieldDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class HopeFieldQueryService {

    private final Database database;

    public List<ProgrammerFieldDTO> execute(){
        List<Registration> allRegistration = database.getAllRegistration();
        Map<HopeField, List<Registration>> hopeFieldListMap = allRegistration.stream().collect(groupingBy(Registration::getHopeField));
        List<Registration> registrations = hopeFieldListMap.keySet().stream()
                .filter(hopeField -> hopeField.isProgrammer(hopeField))
                .flatMap(hopeField -> hopeFieldListMap.get(hopeField).stream())
                .toList();
        // 프로그래머만 존재

        Map<ProgrammerField, List<Registration>> firstPriorityMap = registrations.stream().collect(groupingBy(Registration::getFirstPriority));
        Map<ProgrammerField, List<Registration>> secondPriorityMap = registrations.stream().collect(groupingBy(Registration::getSecondPriority));

        return firstPriorityMap.keySet().stream()
                .map(programmerField -> ProgrammerFieldDTO.of(programmerField.name(), firstPriorityMap.get(programmerField).size(),secondPriorityMap.get(programmerField).size())).toList();

    }
}
