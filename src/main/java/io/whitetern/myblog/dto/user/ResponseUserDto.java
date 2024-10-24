package io.whitetern.myblog.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
public class ResponseUserDto {
    private String loginId;
    private String name;
    private String email;
    private LocalDateTime birthDate;
}
