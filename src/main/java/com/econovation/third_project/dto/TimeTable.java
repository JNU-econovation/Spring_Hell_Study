package com.econovation.third_project.dto;

import com.econovation.third_project.database.DesiredTime;
import com.econovation.third_project.domain.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TimeTable {

    String registrationId;
    private Table desiredTime;

    public static List<TimeTable> from(DesiredTime desiredTime){
        return desiredTime.getDesiredTime().stream()
                .map(dt -> new TimeTable(dt.name(),dt))
                .toList();
    }

}
