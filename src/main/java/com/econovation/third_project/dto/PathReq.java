package com.econovation.third_project.dto;

import com.econovation.third_project.database.Path;
import java.util.Set;

public record PathReq(Set<String> paths) {
    public Path toEntity(){
        return Path.from(paths);
    }
}
