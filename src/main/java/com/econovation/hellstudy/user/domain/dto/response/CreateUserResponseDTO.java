package com.econovation.hellstudy.user.domain.dto.response;

import com.econovation.hellstudy.common.domain.dto.response.AbstractResponseDto;
import com.econovation.hellstudy.user.application.model.UserModel;

public record CreateUserResponseDTO(Long userId, String userName) implements AbstractResponseDto {
    public static CreateUserResponseDTO of(UserModel model){
        return new CreateUserResponseDTO(model.userId(), model.userName());
    }

    public static String getMessage(){
        return "유저가 생성되었습니다.";
    }
}
