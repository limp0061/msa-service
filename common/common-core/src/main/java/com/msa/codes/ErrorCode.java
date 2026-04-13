package com.msa.codes;

public interface ErrorCode {

    String name();

    String getCode();

    int getStatus();

    String getMessageKey();
}
