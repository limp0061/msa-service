package com.msa.dto;

public record FieldErrorDetail(
        String field,
        String reason
) {
}
