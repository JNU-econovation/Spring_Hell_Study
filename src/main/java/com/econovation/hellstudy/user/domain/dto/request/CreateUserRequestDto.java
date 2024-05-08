package com.econovation.hellstudy.user.domain.dto.request;

import com.econovation.hellstudy.common.domain.dto.request.AbstractRequestDto;

public record CreateUserRequestDto(String userName, String loginId, String password) implements AbstractRequestDto {

}
