package com.msa.exception;

import com.msa.codes.ErrorCode;
import lombok.Getter;

@Getter
public abstract class BusinessException extends RuntimeException {
    private final ErrorCode errorCode;
    private final Object data;

    protected BusinessException(ErrorCode errorCode) {
        this(errorCode, errorCode.getMessageKey(), null);
    }

    protected BusinessException(ErrorCode errorCode, String message) {
        this(errorCode, message, null);
    }

    protected BusinessException(ErrorCode errorCode, String message, Object data) {
        super(message != null ? message : errorCode.getMessageKey());
        this.errorCode = errorCode;
        this.data = data;
    }
}
