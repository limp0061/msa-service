package com.msa.common.exception;

import com.msa.common.codes.AuthErrorCode;

public class UnAuthorizationException extends BusinessException {

    public UnAuthorizationException() {
        super(AuthErrorCode.UNAUTHORIZED);
    }

    public UnAuthorizationException(String message) {
        super(AuthErrorCode.UNAUTHORIZED, message);
    }

    public UnAuthorizationException(String message, Object data) {
        super(AuthErrorCode.UNAUTHORIZED, message, data);
    }
}
