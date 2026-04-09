package com.msa.common.dto;

public record FieldErrorDetail(
        String field,
        String reason
) {
}
