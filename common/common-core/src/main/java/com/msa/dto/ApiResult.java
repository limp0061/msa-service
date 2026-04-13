package com.msa.dto;

import com.msa.codes.ErrorCode;

public record ApiResult<T>(
        boolean success,
        T data,
        String code,
        String message
) {
    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(true, data, null, "요청에 성공하였습니다");
    }

    public static ApiResult<Void> error(ErrorCode errorCode, String message) {
        return new ApiResult<>(false, null, errorCode.name(), message);
    }

    public static <T> ApiResult<T> error(T data, ErrorCode errorCode, String message) {
        return new ApiResult<>(false, data, errorCode.name(), message);
    }
}
