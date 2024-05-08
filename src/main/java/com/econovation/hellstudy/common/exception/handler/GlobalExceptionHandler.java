package com.econovation.hellstudy.common.exception.handler;

import com.econovation.hellstudy.common.api.ApiResponse;
import com.econovation.hellstudy.common.api.ApiUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Controller
public class GlobalExceptionHandler {

    private static String interruptedErrCode = "5000";

    @ExceptionHandler(InterruptedException.class)
    public ApiResponse<String> interruptedHandle(InterruptedException exception){
        return ApiUtils.failure(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), interruptedErrCode);
    }

}
