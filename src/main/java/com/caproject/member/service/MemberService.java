package com.caproject.member.service;

import com.caproject.member.dto.MemberResponse;
import com.caproject.member.entity.Member;
import com.caproject.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public MemberResponse findById(Long id) {

        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 멤버를 찾을 수 없습니다."));

        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .age(member.getAge())
                .mbti(member.getMbti())
                .build();
    }
    }