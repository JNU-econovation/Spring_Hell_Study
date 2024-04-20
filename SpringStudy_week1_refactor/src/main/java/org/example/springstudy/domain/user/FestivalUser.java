package org.example.springstudy.domain.user;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
@Getter
public class FestivalUser extends UserBaseEntity{
    @Enumerated(EnumType.STRING)
    private Role role;
}
