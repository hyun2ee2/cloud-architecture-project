package com.caproject.member.dto;

import lombok.Builder;

@Builder
public record CreateMemberResponse(
        String name,
        Integer age,
        String mbti
) {
}
