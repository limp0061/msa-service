package com.msa.exception;

import com.msa.codes.CommonErrorCode;

public class DuplicateException extends BusinessException {
    public DuplicateException() {
        super(CommonErrorCode.DUPLICATE);
    }

    public DuplicateException(String target) {
        super(CommonErrorCode.DUPLICATE, target + "이(가) 이미 존재합니다.");
    }

    public DuplicateException(String target, Object data) {
        super(CommonErrorCode.DUPLICATE, target + "이(가) 이미 존재합니다.", data);
    }
}
