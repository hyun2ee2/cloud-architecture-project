package com.caproject.member.controller;

import com.caproject.member.dto.MemberResponse;
import com.caproject.member.entity.Member;
import com.caproject.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        return memberService.save(member);
    }

    // 멤버 조회
    @GetMapping("/{id}")
    public MemberResponse getMember(@PathVariable Long id) {
        return memberService.findById(id);
    }
}
