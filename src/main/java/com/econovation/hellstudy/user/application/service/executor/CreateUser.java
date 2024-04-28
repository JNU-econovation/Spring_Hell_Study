package com.econovation.hellstudy.user.application.service.executor;

import com.econovation.hellstudy.database.Database;
import com.econovation.hellstudy.database.User;
import com.econovation.hellstudy.user.application.model.UserModel;
import com.econovation.hellstudy.user.application.usecase.CreateUserUseCase;
import com.econovation.hellstudy.user.domain.dto.request.CreateUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUser implements CreateUserUseCase {

    private final Database database;

    // userId
    private Long userCnt = 0L;

    // InterruptedException 처리
    public UserModel createUser(String loginId, String password, String userName) throws InterruptedException{
        UserModel newUserModel = new UserModel(++userCnt ,loginId, password, userName);
        User user = User.from(newUserModel);
        database.createUser(++userCnt, user);
        return newUserModel;
    }
}
