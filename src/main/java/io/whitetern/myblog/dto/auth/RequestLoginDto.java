package io.whitetern.myblog.dto.auth;

import io.whitetern.myblog.constants.ErrorMessage;
import io.whitetern.myblog.constants.RegularExpression;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RequestLoginDto(
    @NotBlank(message = ErrorMessage.EMPTY_LOGIN_ID)
    @Pattern(regexp = RegularExpression.LOGIN_ID, message = ErrorMessage.INVALID_LOGIN_ID)
    String loginId,

    @NotBlank(message = ErrorMessage.EMPTY_PASSWORD)
    String password
) {}
