package com.econovation.third_project.service;


import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.Job;
import com.econovation.third_project.database.JobField;
import com.econovation.third_project.database.Registration;
import com.econovation.third_project.dto.ApplicantNumberByJobRes;
import com.econovation.third_project.dto.ApplicantNumbersByJobFieldAndPriorityRes;
import com.econovation.third_project.dto.JobFieldByPriority;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.persistence.criteria.CriteriaBuilder.In;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final Database db;

    //분야별 지원자 수 read
    public List<ApplicantNumberByJobRes> getApplicantNumbersByJob(){
        //특정 기수만 필터링했다고 가정
        Map<Job, Long> map = db.getRegistrations().stream()
                        .collect(Collectors.groupingBy(Registration::getHopeJob, Collectors.counting()));
        //TODO: 내림차순 정렬
        List<ApplicantNumberByJobRes> applicantNumbers = new ArrayList<>();
        map.forEach((job, number)-> applicantNumbers.add(new ApplicantNumberByJobRes(job, number.intValue())));
        return applicantNumbers;
    }

    //지원 조회
    public Registration getRegistration(String registrationId){
        return db.getRegistration(registrationId);
    }

    public List<ApplicantNumbersByJobFieldAndPriorityRes> getApplicantNumbersByJobFieldAndPriority(){ //메서드를 유연하게 만들 필요가 있어보임...
        // dto(몇 순위, 분야)
        // 없는건 안만들어야 함

        //특정 기수만 필터링했다고 가정
        Collection<Registration> registrations = db.getRegistrations();
        //두 가지 조건을 조합해서 그룹핑해야 하는데..

    }

    //지원 등록
//    public PostRegistrationRes postRegistration()

    //지원 수정

    //지원 삭제

}
