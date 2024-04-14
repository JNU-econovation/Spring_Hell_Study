package com.econovation.springstudy.common.application.dto;

import com.econovation.springstudy.common.application.dto.reponse.ApiResponse;

public class ApiUtils {

    public static <T> SuccessBody<T> successBody(String status, String message, T response) {
        return new SuccessBody<T>(status, message, response);
    }

    public static class SuccessBody<T> implements ApiResponse<T> {
        private String status;
        private String message;
        private T data;

        public SuccessBody(String status, String message, T data){
            this.status = status;
            this.message = message;
            this.data = data;
        }

        public String getStatus(){ return status; }
        public String getMessage(){ return message; }
        public T getData(){ return data; }
    }

    public static class FailureBody<T> implements ApiResponse<T>{
        private String status;
        private String message;

        public FailureBody(String status, String message){
            this.status = status;
            this.message = message;
        }

        public String getStatus(){ return status; }
        public String getMessage() { return message; }
    }
}
