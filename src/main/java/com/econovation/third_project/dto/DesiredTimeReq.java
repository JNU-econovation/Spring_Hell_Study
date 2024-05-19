package com.econovation.third_project.dto;

import com.econovation.third_project.database.DesiredTime;
import com.econovation.third_project.database.DesiredTime27;
import java.util.List;

public record DesiredTimeReq(List<List<Integer>> desiredTimes){
    public DesiredTime toEntity(){
        return new DesiredTime27(desiredTimes);
    }
}
