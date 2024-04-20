package org.example.springstudy.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserBaseEntity, Long> {

}
