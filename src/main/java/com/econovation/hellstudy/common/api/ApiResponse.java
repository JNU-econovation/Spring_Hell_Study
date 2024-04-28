package com.econovation.hellstudy.common.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

public record ApiResponse<T>(HttpStatus code, String message, T data) {

}
