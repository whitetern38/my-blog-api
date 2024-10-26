package io.whitetern.myblog.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.whitetern.myblog.constants.ErrorMessage;
import io.whitetern.myblog.constants.RegularExpression;
import io.whitetern.myblog.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestCreateUserDto {

    @NotBlank(message = ErrorMessage.EMPTY_LOGIN_ID)
    @Pattern(regexp = RegularExpression.LOGIN_ID, message = ErrorMessage.INVALID_LOGIN_ID)
    private String loginId;

    @NotBlank(message = ErrorMessage.EMPTY_PASSWORD)
    @Pattern(regexp = RegularExpression.PASSWORD, message = ErrorMessage.INVALID_PASSWORD)
    private String password;

    @NotBlank(message = ErrorMessage.EMPTY_CONFIRM_PASSWORD)
    @Pattern(regexp = RegularExpression.PASSWORD, message = ErrorMessage.INVALID_CONFIRM_PASSWORD)
    private String passwordConfirm;

    @NotBlank(message = ErrorMessage.EMPTY_NAME)
    private String name;

    @Email(message = ErrorMessage.INVALID_EMAIL)
    private String email;

    @Pattern(regexp = RegularExpression.PHONE_NUMBER, message = ErrorMessage.INVALID_PHONE)
    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthDate;

    public User toEntity(PasswordEncoder passwordEncoder) {
        return User.builder()
                .loginId(loginId)
                .password(passwordEncoder.encode(password))
                .name(name)
                .email(email)
                .phone(phone)
                .birthDate(birthDate)
                .build();
    }

}
