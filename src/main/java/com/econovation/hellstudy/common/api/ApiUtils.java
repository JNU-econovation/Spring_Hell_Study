package com.econovation.hellstudy.common.api;

import com.econovation.hellstudy.common.domain.dto.response.AbstractResponseDto;
import org.springframework.http.HttpStatus;

public class ApiUtils {

    public static ApiResponse<AbstractResponseDto> success(HttpStatus httpCode, String message, AbstractResponseDto response){
        return new ApiResponse<AbstractResponseDto>(httpCode, message, response);
    }

    public static ApiResponse<String> failure(HttpStatus httpCode, String message, String errCode){
        return new ApiResponse<>(httpCode, message, errCode);
    }

}
