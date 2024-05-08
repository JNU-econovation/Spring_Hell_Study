package com.econovation.hellstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class HellStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(HellStudyApplication.class, args);
    }
}
