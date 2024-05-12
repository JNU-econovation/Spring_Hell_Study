package com.econovation.third_project.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * 이 클래스는 변경하지 않습니다.
 * 단, 기능을 추가할 경우에는 메소드 추가를 허용하며, 수정은 금지합니다.
 */
@Component
public class Database {
    private final Map<String, Registration> registration = new HashMap<>();
    private final Map<String, Path> path = new HashMap<>();
    private final Map<String, PersonalInformation> personalInformation = new HashMap<>();
    private final Map<String, DesiredTime> desiredTime = new HashMap<>();


    public void register(Registration registrationRequest) {
        // 기본적으로 이전 제출시 등록된 정보가 있으면 덮어쓰기를 지원합니다.
        registration.put(UUID.randomUUID().toString(), registrationRequest);
    }

    public List<Path> getPaths(){ return path.values().stream().toList(); }

    public List<DesiredTime> getDesiredTimes(){ return desiredTime.values().stream().toList(); }

    public List<PersonalInformation> getPersonalInformations(){ return personalInformation.values().stream().toList(); }

    public List<Registration> getRegistrations(){ return registration.values().stream().toList(); }

    public Registration getRegistration(String userId) {
        return registration.get(userId);
    }
}