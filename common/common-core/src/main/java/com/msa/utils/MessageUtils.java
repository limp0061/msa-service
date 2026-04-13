package com.msa.utils;

import com.msa.codes.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageUtils {
    private final MessageSource messageSource;

    public String getMessage(String key, Object[] args) {
        try {
            return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException e) {
            return key;
        }
    }

    public String getMessage(ErrorCode errorCode) {
        return getMessage(errorCode.getMessageKey(), null);
    }

    public String getMessage(String key) {
        return getMessage(key, null);
    }
}
