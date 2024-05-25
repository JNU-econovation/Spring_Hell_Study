package com.econovation.third_project.database;

import com.econovation.third_project.config.SupportPath;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Path{
    // 지원 경로
    private final EnumSet<SupportPath> supportPaths;

    public Path(EnumSet<SupportPath> supportPaths) {
        this.supportPaths = supportPaths;
    }

    public static Path from(Set<String> stringPaths){
        EnumSet<SupportPath> enumPaths = EnumSet.noneOf(SupportPath.class);
        stringPaths.stream()
                .forEach(stringPath-> enumPaths.add(SupportPath.valueOf(stringPath.toUpperCase())));
        return new Path(enumPaths);
    }
}
