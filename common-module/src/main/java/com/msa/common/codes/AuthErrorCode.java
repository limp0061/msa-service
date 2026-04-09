package com.msa.common.codes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum AuthErrorCode implements ErrorCode {

    UNAUTHORIZED("A001", HttpStatus.UNAUTHORIZED, "error.unauthorized"),
    FORBIDDEN("A002", HttpStatus.FORBIDDEN, "error.forbidden");
    private final String code;
    private final HttpStatus httpStatus;
    private final String messageKey;
}
