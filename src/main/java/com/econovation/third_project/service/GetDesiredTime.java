package com.econovation.third_project.service;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.DesiredTime;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetDesiredTime {

    private final Database db;

    public DesiredTimeMapper getAllDesiredTime() {
        Map<String, DesiredTime> allDesiredTime = db.getAllDesiredTime();
        for (String key : allDesiredTime.keySet()){
            DesiredTime desiredTime = allDesiredTime.get(key);
            for (int[] times: desiredTime.getDesiredTime()){
                int startTime = times[0];
                int endTime = times[1];


            }

        }
    }

}
