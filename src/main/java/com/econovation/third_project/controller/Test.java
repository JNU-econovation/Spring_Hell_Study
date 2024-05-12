package com.econovation.third_project.controller;

import com.econovation.third_project.database.Registration;
import com.econovation.third_project.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class Test {
    RegistrationService registrationService;

    @PostMapping("/register")
    public String register(@RequestBody Registration registration){
        // 예외처리 필요할듯하다.
        registrationService.register(registration);
        return "success";
    }

    @GetMapping("/register-count")
    public Integer getTotalRegisterCount(){
        return registrationService.getRegistrationCount();
    }

    @GetMapping("/register-hope-count")
    public ArrayList<Integer> getHopeFieldsTotalRegisterCount(){
        return registrationService.getHopeFieldsTotalCount();
    }



}
