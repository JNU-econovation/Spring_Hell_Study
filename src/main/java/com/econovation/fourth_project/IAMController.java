package com.econovation.fourth_project;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IAMController {
    @GetMapping("/check/resource/{resource}")
    public boolean getResult(@PathVariable("resource") String resource){

    }

    @GetMapping("/")
    public Map<String, Boolean>
}
