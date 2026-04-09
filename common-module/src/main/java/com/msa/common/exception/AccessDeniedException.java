package com.msa.common.exception;

import com.msa.common.codes.AuthErrorCode;

public class AccessDeniedException extends BusinessException {
    public AccessDeniedException() {
        super(AuthErrorCode.FORBIDDEN);
    }

    public AccessDeniedException(String message) {
        super(AuthErrorCode.FORBIDDEN, message);
    }

    public AccessDeniedException(String message, Object data) {
        super(AuthErrorCode.FORBIDDEN, message, data);
    }
}
