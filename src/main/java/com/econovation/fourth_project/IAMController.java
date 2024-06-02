package com.econovation.fourth_project;

import com.econovation.fourth_project.common.requestDTO.MethodRequest;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IAMController {
    @GetMapping("/check/resource/{resource}")
    public boolean getResult(@RequestBody MethodRequest, @PathVariable("resource") String resource){

    }

    @GetMapping("/")
    public Map<String, Boolean>
}
