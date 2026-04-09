package com.msa.common.dto;

import com.msa.common.codes.ErrorCode;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "공통 응답 규격")
public record ApiResult<T>(
        @Schema(description = "요청 성공 여부", example = "true")
        boolean success,

        @Schema(description = "응답 데이터")
        T data,

        @Schema(description = "에러 코드 (실패 시)", example = "C001")
        String code,

        @Schema(description = "에러 메시지 (실패 시)", example = "잘못된 입력값입니다.")
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
