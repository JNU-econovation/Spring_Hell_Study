package com.econovation.third_project.service;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.DesiredTime;
import com.econovation.third_project.domain.Table;
import com.econovation.third_project.dto.DesiredTimeDTO;
import com.econovation.third_project.dto.TimeTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class DesiredTimeQueryService {

    private final Database database;

    public List<DesiredTimeDTO> execute(){
        List<DesiredTime> allDesiredTime = database.getAllDesiredTime();

        List<TimeTable> timeTables = allDesiredTime.stream()
                .flatMap(adt -> TimeTable.from(adt).stream())
                .toList();

        Map<Table, List<TimeTable>> tableListMap = timeTables.stream().collect(groupingBy(TimeTable::getDesiredTime));
        List<DesiredTimeDTO> desiredTimeDTOS = tableListMap.keySet().stream()
                .map(table ->
                        DesiredTimeDTO.of(
                                table,
                                tableListMap.get(table).size(),
                                database.getPersonalInformation(
                                        tableListMap.get(table).stream()
                                                .map(timeTable -> timeTable.getPersonalInfoId()).toList()))
                ).toList();

        return desiredTimeDTOS;
    }
}
