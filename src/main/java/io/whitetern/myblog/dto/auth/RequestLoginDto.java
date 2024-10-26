package io.whitetern.myblog.dto.auth;

import io.whitetern.myblog.constants.ErrorMessage;
import io.whitetern.myblog.constants.RegularExpression;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestLoginDto {

    @NotBlank(message = ErrorMessage.EMPTY_LOGIN_ID)
    @Pattern(regexp = RegularExpression.LOGIN_ID, message = ErrorMessage.INVALID_LOGIN_ID)
    private String loginId;

    @NotBlank(message = ErrorMessage.EMPTY_PASSWORD)
    private String password;

}
