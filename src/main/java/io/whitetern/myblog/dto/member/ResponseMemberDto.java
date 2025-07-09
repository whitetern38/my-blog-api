package io.whitetern.myblog.dto.member;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ResponseMemberDto(
    String loginId,
    String email,
    String phone,
    String name,
    LocalDate birthday
) {}
