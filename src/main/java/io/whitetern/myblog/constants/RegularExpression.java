package io.whitetern.myblog.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RegularExpression {

    public static final String LOGIN_ID = "^[a-z0-9]{5,20}$";

    public static final String PASSWORD = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$";

    public static final String PHONE_NUMBER = "^\\d{2,3}-\\d{3,4}-\\d{4}$";

}