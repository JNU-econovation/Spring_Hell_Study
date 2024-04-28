package com.econovation.hellstudy.user.application.usecase;

import com.econovation.hellstudy.user.application.model.UserModel;
import com.econovation.hellstudy.user.domain.dto.request.CreateUserRequestDto;

public interface CreateUserUseCase {

    public UserModel createUser(String loginId, String password, String userName) throws InterruptedException;

}
