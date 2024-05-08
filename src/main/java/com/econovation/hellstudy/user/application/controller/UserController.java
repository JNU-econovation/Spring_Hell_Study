package com.econovation.hellstudy.user.application.controller;

import com.econovation.hellstudy.common.api.ApiResponse;
import com.econovation.hellstudy.common.api.ApiUtils;
import com.econovation.hellstudy.common.domain.dto.response.AbstractResponseDto;
import com.econovation.hellstudy.user.application.service.UserService;
import com.econovation.hellstudy.user.domain.dto.request.CreateUserRequestDto;
import com.econovation.hellstudy.user.domain.dto.response.CreateUserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ApiResponse<AbstractResponseDto> createUser(
            @RequestBody CreateUserRequestDto request
            ) throws InterruptedException{
        CreateUserResponseDTO response = userService.createUser(request);
        return ApiUtils.success(HttpStatus.OK, CreateUserResponseDTO.getMessage(), response);
    }

}
