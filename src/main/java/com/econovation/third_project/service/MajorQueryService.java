package com.econovation.third_project.service;


import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.PersonalInformation;
import com.econovation.third_project.database.Registration;
import com.econovation.third_project.domain.HopeField;
import com.econovation.third_project.domain.Major;
import com.econovation.third_project.dto.ApplicantDTO;
import com.econovation.third_project.dto.MajorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MajorQueryService {

    private final Database database;

    public List<MajorDTO> execute(){
        List<PersonalInformation> allPersonalInformation = database.getAllPersonalInformation();
        Map<Major, List<PersonalInformation>> majorListMap = allPersonalInformation.stream().collect(Collectors.groupingBy(PersonalInformation::getMajor));
        Map<Major, List<PersonalInformation>> doubleMajorListMap = allPersonalInformation.stream().collect(Collectors.groupingBy(PersonalInformation::getDoubleMajor));
        return majorListMap.keySet().stream()
                .map(major -> MajorDTO.of(major.name(), majorListMap.get(major).size() + doubleMajorListMap.get(major).size())).toList();
    }
}
