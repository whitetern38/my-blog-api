package io.whitetern.myblog.dto;

import io.whitetern.myblog.constants.ErrorCode;
import org.springframework.http.ResponseEntity;

public class ApiResponse<T> {

    private int code;
    private String message;
    private T data;

    private ApiResponse() {};

    protected ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(T data) {
        return ResponseEntity.ok(new ApiResponse<T>(2000, "success", data));
    }

    public static ResponseEntity<?> fail(ErrorCode errorCode) {
        return ResponseEntity
                .status(errorCode.getStatus())
                .build();
    }

}
