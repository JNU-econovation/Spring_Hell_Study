package org.example.springstudy.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FestivalUserRepository extends JpaRepository<FestivalUser, Long> {
    public List<FestivalUser> findAllByRole(Role role);
}
