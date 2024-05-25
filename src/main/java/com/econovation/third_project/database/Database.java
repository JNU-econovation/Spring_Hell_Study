package com.econovation.third_project.database;

import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

/**
 * 이 클래스는 변경하지 않습니다.
 * 단, 기능을 추가할 경우에는 메소드 추가를 허용하며, 수정은 금지합니다.
 */
@Component
public class Database {
    //key: user id, value: application id
    private final Map<Integer, Integer> applications = new ConcurrentHashMap<>();
    //key: application id
    private final Map<Integer, Registration> registrations = new ConcurrentHashMap<>();
    //key: application id
    private final Map<Integer, Path> paths = new ConcurrentHashMap<>();
    //key: application id
    private final Map<Integer, PersonalInformation> personalInformation = new ConcurrentHashMap<>();
    //key: application id
    private final Map<Integer, DesiredTime> desiredTimes = new ConcurrentHashMap<>();

    public Collection<Registration> getAllRegistrations(){
        return registrations.values();
    }
    public Collection<PersonalInformation> getAllPersonalInformation(){
        return personalInformation.values();
    }
    public Collection<Path> getAllPath() {
        return paths.values();
    }
    public Collection<DesiredTime> getAllDesiredTime(){
        return desiredTimes.values();
    }

    //지원자는 userId가 없으니 같은 지원서인지 판단할 기준을 따로 만들어야 함
    public Integer upsertApplication(Integer userId, Application application){
        Integer applicationId = applications.computeIfAbsent(userId, k -> application.getApplicationId());
        upsertRegistration(applicationId, application.getRegistration());
        upsertPath(applicationId, application.getPath());
        upsertDesiredTime(applicationId, application.getDesiredTime());
        upsertPersonalInformation(applicationId, application.getPersonalInformation());
        return applicationId;
    }
    public void upsertRegistration(Integer applicationId, Registration registration){
        registrations.put(applicationId, registration);
    }
    public void upsertPath(Integer applicationId, Path path){
        paths.put(applicationId, path);
    }
    public void upsertPersonalInformation(Integer applicationId, PersonalInformation personalInformation){
        this.personalInformation.put(applicationId, personalInformation);
    }
    public void upsertDesiredTime(Integer applicationId, DesiredTime desiredTime){
        desiredTimes.put(applicationId, desiredTime);
    }



//    public void register(Registration registrationRequest) {
//        // 기본적으로 이전 제출시 등록된 정보가 있으면 덮어쓰기를 지원합니다.
//        registration.put(UUID.randomUUID().toString(), registrationRequest);
//    }
//
//    public Registration getRegistration(String userId) {
//        return registration.get(userId);
//    }





}