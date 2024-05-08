package com.econovation.hellstudy.user.application.service;

import com.econovation.hellstudy.database.Database;
import com.econovation.hellstudy.user.application.model.UserModel;
import com.econovation.hellstudy.user.application.usecase.CreateUserUseCase;
import com.econovation.hellstudy.user.domain.dto.request.CreateUserRequestDto;
import com.econovation.hellstudy.user.domain.dto.response.CreateUserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService{

    private final CreateUserUseCase userCreator;

    public CreateUserResponseDTO createUser(CreateUserRequestDto request) throws InterruptedException{
        UserModel newUser = create(request);
        return CreateUserResponseDTO.of(newUser);
    }

    private UserModel create(CreateUserRequestDto request) throws InterruptedException {
        return userCreator.createUser(
                request.loginId(),
                request.password(),
                request.userName()
        );
    }

}
