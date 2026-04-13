package com.msa.exception;

import com.msa.codes.AuthErrorCode;

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
