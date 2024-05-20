package com.econovation.third_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAdminPage {
    private final GetApplicant getApplicant;
    private final GetDesiredTime getDesiredTime;
    private final GetMajor getMajor;
    private final GetPath getPath;
}
