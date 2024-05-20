package com.econovation.third_project.database;

import java.util.*;

import org.springframework.stereotype.Component;

/**
 * 이 클래스는 변경하지 않습니다.
 * 단, 기능을 추가할 경우에는 메소드 추가를 허용하며, 수정은 금지합니다.
 */
@Component
public class Database {
    //key : userId
    private final Map<String, Registration> registration = new HashMap<>();
    private final Map<String, Path> path = new HashMap<>();
    private final Map<String, PersonalInformation> personalInformation = new HashMap<>();
    private final Map<String, DesiredTime> desiredTime = new HashMap<>();


    public void register(Registration registrationRequest) {
        // 기본적으로 이전 제출시 등록된 정보가 있으면 덮어쓰기를 지원합니다.
        registration.put(UUID.randomUUID().toString(), registrationRequest);
    }

    public Registration getRegistration(String userId) {
        return registration.get(userId);
    }

    public Collection<Registration> findAllRegistration() {return registration.values();}

    public Collection<PersonalInformation> findAllPersonalInformation() {return personalInformation.values();}

    public Collection<Path> findAllPath() {return path.values();}

    public Collection<DesiredTime> findAllDesiredTime() {return desiredTime.values();}
}