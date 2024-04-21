package com.example.study.member.service;

import com.example.study.member.domain.Member;
import com.example.study.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member find(String name){
         return memberRepository.findByName(name).orElseThrow(NullPointerException::new);
    }
}
