package com.caproject.member.dto;

import lombok.Builder;

@Builder
public record GetMemberResponse(
        Long id,
        String name,
        Integer age,
        String mbti
) {
}
