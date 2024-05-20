package com.econovation.third_project;

import com.econovation.second_project.HellStudyApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ThirdStudyApplication {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2021, 1, 2);
        localDate.with()
        SpringApplication.run(ThirdStudyApplication.class, args);
    }
}
