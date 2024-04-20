package org.example.springstudy.controller.user;

import lombok.RequiredArgsConstructor;
import org.example.springstudy.dto.user.request.CityHallUserJoinDTO;
import org.example.springstudy.dto.user.request.FestivalUserJoinDTO;
import org.example.springstudy.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/new/cityHallUser")
    public void createUser(@RequestBody CityHallUserJoinDTO cityHallUserJoinDTO){
        userService.join(cityHallUserJoinDTO);
    }

    @PostMapping("/new/festivalUser")
    public void createUser(@RequestBody FestivalUserJoinDTO festivalUserJoinDTO){
        userService.join(festivalUserJoinDTO);
    }
}
