package com.econovation.third_project.database;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PersonalInformation {

    // 이름
    private String name;

    // 핸드폰 번호
    private String phoneNumber;

    // 학번
    private Integer studentId;

    // 학년
    private Integer grade;

    // 학기
    private Integer semester;

    // 전공
    private String major;

    // 복수전공
    private String doubleMajor;
    // 부전공
    private String minor;

    // 이메일
    private String email;

    public Optional<String> getDoubleMajor() {
        return Optional.ofNullable(this.doubleMajor);
    }

    public Optional<String> getMinor() {
        return Optional.ofNullable(this.minor);
    }

}
