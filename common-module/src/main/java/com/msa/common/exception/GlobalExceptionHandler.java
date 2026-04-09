package com.msa.common.exception;

import com.msa.common.codes.CommonErrorCode;
import com.msa.common.codes.ErrorCode;
import com.msa.common.dto.ApiResult;
import com.msa.common.dto.FieldErrorDetail;
import com.msa.common.utils.MessageUtils;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageUtils messageUtils;

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ApiResult<Void>> businessException(BusinessException e) {
        ErrorCode errorCode = e.getErrorCode();
        String errMessage = messageUtils.getMessage(errorCode);

        log.warn("[BusinessException] {} - {} - {}",
                e.getClass().getSimpleName(),
                errMessage,
                e.getData()
        );

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(ApiResult.error(errorCode, errMessage));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResult<List<FieldErrorDetail>>> methodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        List<FieldErrorDetail> errorDetails = e.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> new FieldErrorDetail(
                        error.getField(),
                        messageUtils.getMessage(error.getDefaultMessage())
                ))
                .toList();

        ErrorCode errorCode = CommonErrorCode.INVALID_INPUT;
        String errMessage = messageUtils.getMessage(errorCode);
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(ApiResult.error(errorDetails, errorCode, errMessage));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResult<Void>> exceptionHandler(Exception e) {
        log.error("[UnHandled Exception]", e);
        ErrorCode errorCode = CommonErrorCode.INTERNAL_SERVER_ERROR;
        String errMessage = messageUtils.getMessage(errorCode);
        
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(ApiResult.error(errorCode, errMessage));
    }
}
