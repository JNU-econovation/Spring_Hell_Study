package com.econovation.third_project.database;

import java.util.*;

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

    public Registration getRegistration(String userId) {
        return registration.get(userId);
    }

    // 희망 분야별로 1지망, 2지망 카운트
    // 희망 분야 6개, 6개 마다 1지망, 2지망 count
    public HashMap<String,ArrayList<Integer>> getRegistrationHopeFieldsTotalCount(){
        HashMap<String,ArrayList<Integer>> registrationHopefields = new HashMap<>();
        // 조건 분기 하나하나 나누는건 뭔가 아닌듯하다... 경우의수만 12가지
        // 자동 순환, 자동 count => 이걸 지원하는 기능을 찾을 필요성이 있다.


    }



    // 서비스 파일에 작성해야 하는 로직인지 확인하기
    public int getRegistrationCount(){
        return registration.size();
    }

    // 개발자, 기획자, 디자이너 각각 Count // 서비스 파일에 작성해야 하는 로직인지 확인하기
    public ArrayList<Integer> getHopeFieldsTotalCount(){
        ArrayList<Integer> hopeFields = new ArrayList<Integer>(3);
        // 초기화 방식도 뭔가 이상하다
        hopeFields.add(0);
        hopeFields.add(0);
        hopeFields.add(0);
        Integer count = 0;
        // 할 수 있는 조회 방법, 너무 하드 코딩 같다
        for(Map.Entry<String,Registration> entrySet : registration.entrySet()){
            if(entrySet.getValue().getHopeField().equals("개발자")){ // == 의 경우 비교 연산이 이뤄지지 않음
                count = hopeFields.get(0);
                hopeFields.set(0,count+1);
            }
            else if(entrySet.getValue().getHopeField().equals("기획자")){
                count = hopeFields.get(1);
                hopeFields.set(1,count+1);
            }
            else if(entrySet.getValue().getHopeField().equals("디자이너")){
                count = hopeFields.get(2);
                hopeFields.set(2,count+1);
            }
            else{
                // 예외 처리
            }
        }
        return hopeFields;
    }

}