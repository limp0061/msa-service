package com.msa.enums;

public interface BaseEnum {

    String getCode();

    default String getDesc() {
        return "";
    }
}
