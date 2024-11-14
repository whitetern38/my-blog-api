package io.whitetern.myblog.constants;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(404, "U410", "존재하지 않는 사용자입니다."),
    PASSWORD_NOT_EQUAL(404, "U411", "비밀번호가 일치하지 않습니다."),
    ALREADY_EXIST_LOGIN_ID(404, "U412", "이미 존재하는 로그인 아이디입니다.");


    private int status;
    private String code;
    private String message;

}
