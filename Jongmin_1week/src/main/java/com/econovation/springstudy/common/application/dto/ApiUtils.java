package com.econovation.springstudy.common.application.dto;

import com.econovation.springstudy.common.application.dto.reponse.ApiResponse;
import org.springframework.http.HttpStatus;

public class ApiUtils {

    public static <T> SuccessBody<T> successBody(T response) {
        return new SuccessBody<T>(HttpStatus.OK.value(), response);
    }

    public static class SuccessBody<T> implements ApiResponse<T> {
        private int status;
        private String message;
        private T data;

        public SuccessBody(int status, T data){
            this.status = status;
            this.message = HttpStatus.OK.name();
            this.data = data;
        }

        public SuccessBody(int status, String message, T data){
            this.status = status;
            this.message = message;
            this.data = data;
        }

        public int getStatus(){ return status; }
        public String getMessage(){ return message; }
        public T getData(){ return data; }
    }

    public static class FailureBody<T> implements ApiResponse<T>{
        private int status;
        private String message;

        public FailureBody(int status, String message){
            this.status = status;
            this.message = message;
        }

        public int getStatus(){ return status; }
        public String getMessage() { return message; }
    }
}
