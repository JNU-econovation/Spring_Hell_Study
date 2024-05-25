package com.econovation.third_project.dto;

import com.econovation.third_project.database.DesiredTime;
import java.util.List;

public record DesiredTimeReq(List<List<Integer>> desiredTimes){
    public DesiredTime toEntity(){
        return new DesiredTime(desiredTimes);
    }
}
