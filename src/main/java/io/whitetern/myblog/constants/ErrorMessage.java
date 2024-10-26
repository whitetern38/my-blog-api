package io.whitetern.myblog.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorMessage {

    public static final String EMPTY_LOGIN_ID = "로그인 아이디를 입력해주세요.";
    public static final String EMPTY_PASSWORD = "비밀번호를 입력해주세요.";
    public static final String EMPTY_CONFIRM_PASSWORD = "확인 비밀번호를 입력해주세요.";
    public static final String EMPTY_NAME = "이름을 입력해주세요.";

    public static final String INVALID_LOGIN_ID = "로그인 아이디 형식이 올바르지 않습니다.";
    public static final String INVALID_PASSWORD = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
    public static final String INVALID_CONFIRM_PASSWORD = "확인 비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
    public static final String INVALID_EMAIL = "이메일 형식이 올바르지 않습니다.";
    public static final String INVALID_PHONE = "휴대폰 번호를 올바르게 입력해주세요.";

}
