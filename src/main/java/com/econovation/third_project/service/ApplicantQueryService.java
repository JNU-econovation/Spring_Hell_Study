package com.econovation.third_project.service;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.Registration;
import com.econovation.third_project.domain.HopeField;
import com.econovation.third_project.dto.ApplicantDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class ApplicantQueryService {

    private final Database database;

    public List<ApplicantDTO> execute(){
        List<Registration> allRegistration = database.getAllRegistration();
        Map<HopeField, List<Registration>> hopeFieldListMap = allRegistration.stream().collect(groupingBy(Registration::getHopeField));
        return hopeFieldListMap.keySet().stream()
                .map(hopeField -> ApplicantDTO.of(hopeField.name(), hopeFieldListMap.get(hopeField).size())).toList();
    }
}
