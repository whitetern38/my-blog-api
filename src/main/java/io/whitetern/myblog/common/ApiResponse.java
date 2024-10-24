package io.whitetern.myblog.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {

    private String status;
    private String message;
    private T data;

//    public static <T> ApiResponse<T> success(T data) {
//        return new ApiResponse<>("success", "");
//    }

}
