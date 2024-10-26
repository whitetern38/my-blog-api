package io.whitetern.myblog.dto.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseUserDto {

    private String loginId;
    private String email;
    private String phone;
    private String name;
    private LocalDate birthday;

    @Builder
    public ResponseUserDto(String loginId, String email, String phone, String name, LocalDate birthday) {
        this.loginId = loginId;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.birthday = birthday;
    }

}
