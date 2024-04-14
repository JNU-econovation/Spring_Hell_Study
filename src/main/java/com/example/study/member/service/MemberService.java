package com.example.study.member.service;

import com.example.study.member.domain.Member;
import com.example.study.member.domain.MemberType;
import com.example.study.member.dto.SignUpMemberRequest;
import com.example.study.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void signUp(SignUpMemberRequest signUpMemberRequest){
        Member member = Member.createMember(signUpMemberRequest.name(), MemberType.valueOf(signUpMemberRequest.type()));
        memberRepository.save(member);
    }

    public Member find(String uuid){
         return memberRepository.findByUUDID(uuid).orElseThrow(NullPointerException::new);
    }
}
