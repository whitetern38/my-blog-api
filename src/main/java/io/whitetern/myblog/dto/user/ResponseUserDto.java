package io.whitetern.myblog.dto.user;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ResponseUserDto(
    String loginId,
    String email,
    String phone,
    String name,
    LocalDate birthday
) {}
