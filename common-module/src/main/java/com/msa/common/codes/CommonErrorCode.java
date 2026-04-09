package com.msa.common.codes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CommonErrorCode implements ErrorCode {

    INVALID_INPUT("C001", HttpStatus.BAD_REQUEST, "error.invalid.input"),
    METHOD_NOT_ALLOWED("C002", HttpStatus.METHOD_NOT_ALLOWED, "error.method.not.allowed"),
    ENTITY_NOT_FOUND("C003", HttpStatus.NOT_FOUND, "error.entity.not.found"),
    INTERNAL_SERVER_ERROR("C004", HttpStatus.INTERNAL_SERVER_ERROR, "error.server.internal"),
    DUPLICATE("C005", HttpStatus.CONFLICT, "error.duplicate");

    private final String code;
    private final HttpStatus httpStatus;
    private final String messageKey;
}
