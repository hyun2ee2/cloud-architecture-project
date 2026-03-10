package com.caproject.member.controller;

import com.caproject.member.dto.GetMemberResponse;
import com.caproject.member.entity.Member;
import com.caproject.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 멤버 생성
    @PostMapping
    public Member createMember(
            @RequestBody
            Member member
    ) {
        log.info("[LOG] 회원 생성 요청");
        return memberService.save(member);
    }

    // 멤버 조회
    @GetMapping("/{id}")
    public GetMemberResponse getMember(@PathVariable Long id) {
        log.info("[LOG] 회원 조회 요청 ID : {}", id);
        return memberService.findById(id);
    }
}
