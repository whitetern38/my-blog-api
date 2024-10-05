package io.whitetern.myblog.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.whitetern.myblog.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestCreateUserDto {

    @Email
    private String email;

    @NotBlank
    private String password1;

    @NotBlank
    private String password2;

    @NotBlank
    private String name;

    @NotBlank
    private String nickname;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthDate;

    public User toEntity(PasswordEncoder passwordEncoder) {
        return User.builder()
                .email(email)
                .password(passwordEncoder.encode(password1))
                .name(name)
                .nickname(nickname)
                .birthDate(birthDate)
                .build();
    }
}
