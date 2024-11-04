package io.whitetern.myblog.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.whitetern.myblog.constants.ErrorMessage;
import io.whitetern.myblog.constants.RegularExpression;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record RequestCreateUserDto(
    @NotBlank(message = ErrorMessage.EMPTY_LOGIN_ID)
    @Pattern(regexp = RegularExpression.LOGIN_ID, message = ErrorMessage.INVALID_LOGIN_ID)
    String loginId,

    @NotBlank(message = ErrorMessage.EMPTY_PASSWORD)
    @Pattern(regexp = RegularExpression.PASSWORD, message = ErrorMessage.INVALID_PASSWORD)
    String password,

    @NotBlank(message = ErrorMessage.EMPTY_CONFIRM_PASSWORD)
    @Pattern(regexp = RegularExpression.PASSWORD, message = ErrorMessage.INVALID_CONFIRM_PASSWORD)
    String passwordConfirm,

    @NotBlank(message = ErrorMessage.EMPTY_NAME)
    String name,

    @Email(message = ErrorMessage.INVALID_EMAIL)
    String email,

    @Pattern(regexp = RegularExpression.PHONE_NUMBER, message = ErrorMessage.INVALID_PHONE)
    String phone,

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime birthDate
) {}
