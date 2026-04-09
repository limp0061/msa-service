package com.msa.common.enums;

public interface BaseEnum {

    String getCode();

    default String getDesc() {
        return "";
    }
}
