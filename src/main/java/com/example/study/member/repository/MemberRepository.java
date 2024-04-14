package com.example.study.member.repository;

import com.example.study.member.domain.Member;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public interface MemberRepository {

    void save(Member member);

    Optional<Member> findByUUDID(String uuid);
}
