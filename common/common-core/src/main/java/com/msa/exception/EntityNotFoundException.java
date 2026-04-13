package com.msa.exception;

import com.msa.codes.CommonErrorCode;

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException() {
        super(CommonErrorCode.ENTITY_NOT_FOUND);
    }

    public EntityNotFoundException(String target) {
        super(CommonErrorCode.ENTITY_NOT_FOUND, target + "을(를) 찾을 수 없습니다.");
    }

    public EntityNotFoundException(String target, Object data) {
        super(CommonErrorCode.ENTITY_NOT_FOUND, target + "을(를) 찾을 수 없습니다.", data);
    }
}
