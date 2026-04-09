package com.msa.common.codes;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

    String name();

    String getCode();

    HttpStatus getHttpStatus();

    String getMessageKey();
}
