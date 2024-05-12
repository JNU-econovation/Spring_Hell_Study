package com.econovation.third_project.controller;

import com.econovation.third_project.database.Database;
import com.econovation.third_project.database.Registration;
import com.econovation.third_project.dto.response.GetAdminPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class AdminQueryController {
    private final Database database;

    // 예시 코드
    @PostMapping("/registration")
    public ResponseEntity<Object> postRegistrate(@RequestBody Registration registration) {
        database.register(registration);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/registration")
    public ResponseEntity<Registration> getRegistration(String userId) {
        return ResponseEntity.ok().body(database.getRegistration(userId));
    }

    @GetMapping("/admin")
    public ResponseEntity<GetAdminPageResponse> getAdminPage() {

        return ResponseEntity.ok().body()
    }

}
