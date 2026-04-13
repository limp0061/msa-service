package com.msa.codes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuthErrorCode implements ErrorCode {

    UNAUTHORIZED("A001", 401, "error.unauthorized"),
    FORBIDDEN("A002", 403, "error.forbidden");
    private final String code;
    private final int status;
    private final String messageKey;
}
