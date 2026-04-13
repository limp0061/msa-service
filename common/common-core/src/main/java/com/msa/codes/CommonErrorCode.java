package com.msa.codes;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum CommonErrorCode implements ErrorCode {

    INVALID_INPUT("C001", 400, "error.invalid.input"),
    METHOD_NOT_ALLOWED("C002", 405, "error.method.not.allowed"),
    ENTITY_NOT_FOUND("C003", 404, "error.entity.not.found"),
    INTERNAL_SERVER_ERROR("C004", 500, "error.server.internal"),
    DUPLICATE("C005", 309, "error.duplicate");

    private final String code;
    private final int status;
    private final String messageKey;
}
