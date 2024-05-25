package com.econovation.third_project.agrregate;

import com.econovation.third_project.service.PathService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PathQuery implements AdminPageQuery{
    private final PathService pathService;
    @Override
    public String getType() {
        return "path";
    }

    @Override
    public List<?> execute() {
        return pathService.getApplicantNumberEachPath();
    }
}
