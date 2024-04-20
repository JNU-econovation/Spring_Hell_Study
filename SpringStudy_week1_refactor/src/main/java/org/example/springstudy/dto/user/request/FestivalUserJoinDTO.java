package org.example.springstudy.dto.user.request;

import jakarta.persistence.Entity;
import lombok.*;
import org.example.springstudy.domain.user.FestivalUser;
import org.example.springstudy.domain.user.Role;


@Getter
public class FestivalUserJoinDTO extends UserJoinDTO{
    private String role;
}
