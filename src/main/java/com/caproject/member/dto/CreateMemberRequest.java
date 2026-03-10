package com.caproject.member.dto;

import lombok.Builder;

@Builder
public record CreateMemberRequest(
        Long MemberId,
        String name,
        Integer age,
        String mbti

) {
}
