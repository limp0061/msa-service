package com.msa.common.exception;

import com.msa.common.codes.CommonErrorCode;

public class InvalidValueException extends BusinessException {
    public InvalidValueException() {
        super(CommonErrorCode.INVALID_INPUT);
    }
    
    public InvalidValueException(String message) {
        super(CommonErrorCode.INVALID_INPUT, message);
    }

    public InvalidValueException(String message, Object data) {
        super(CommonErrorCode.INVALID_INPUT, message, data);
    }
}
