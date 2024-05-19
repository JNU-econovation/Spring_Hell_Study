package com.econovation.third_project.dto.request;

import java.util.List;

public record GetAdminPageRequest(
        List<String> requestInfos) // 지원자 누적 합계, 소속 학과 합계 ....
{
}
