package com.econovation.third_project.service;

import com.econovation.third_project.database.Application;
import com.econovation.third_project.database.Database;
import com.econovation.third_project.dto.CreateApplicationReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final Database db;
    public int createApplication(CreateApplicationReq createApplicationReq){
        Application application = Application.builder()
                .registration(createApplicationReq.registration().toEntity())
                .personalInformation(createApplicationReq.personalInformation().toEntity())
                .path(createApplicationReq.path().toEntity())
                .desiredTime(createApplicationReq.desiredTime().toEntity())
                .build();
        return db.upsertApplication(1, application);
    }

}
