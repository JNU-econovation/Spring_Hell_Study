package org.example.springstudy.service.user;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.example.springstudy.domain.user.*;
import org.example.springstudy.dto.user.request.CityHallUserJoinDTO;
import org.example.springstudy.dto.user.request.FestivalUserJoinDTO;
import org.example.springstudy.dto.user.request.UserJoinDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public Long join(FestivalUserJoinDTO festivalUserJoinDTO){
        FestivalUser festivalUser = FestivalUser.builder()
                .name(festivalUserJoinDTO.getName())
                .role(Role.valueOf(festivalUserJoinDTO.getRole()))
                .build();
        return userRepository.save(festivalUser).getId();
    }

    public Long join(CityHallUserJoinDTO cityHallUserJoinDTO){
        CityHallUser cityHallUser = CityHallUser.builder()
                .name(cityHallUserJoinDTO.getName())
                .budget(cityHallUserJoinDTO.getBudget())
                .build();
        return userRepository.save(cityHallUser).getId();
    }


}
