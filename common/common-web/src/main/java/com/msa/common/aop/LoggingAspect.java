package com.msa.common.aop;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    private static final String UNKNOWN = "UNKNOWN";
    private static final long SLOW_REQUEST_MS = 1000L;

    @Pointcut("execution(* com.msa..*Controller.*(..))")
    private void onRequest() {
    }

    @Around("onRequest()")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        // HTTP 요청
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attrs != null ? attrs.getRequest() : null;

        String uri = request != null ? request.getRequestURI() : UNKNOWN;
        String method = request != null ? request.getMethod() : UNKNOWN;
        long start = System.currentTimeMillis();

        MDC.put("method", method);
        MDC.put("uri", uri);

        try {
            Object proceed = joinPoint.proceed();
            long duration = System.currentTimeMillis() - start;

            if (proceed instanceof ResponseEntity<?> responseEntity) {
                MDC.put("status", String.valueOf(responseEntity.getStatusCode().value()));
            } else {
                MDC.put("status", "200");
            }
            MDC.put("duration", duration + "ms");

            if (duration > SLOW_REQUEST_MS) {
                log.warn("[SLOW_REQUEST]");
            } else {
                log.info("[REQUEST]");
            }

            return proceed;

        } catch (Exception e) {
            long duration = System.currentTimeMillis() - start;
            MDC.put("status", "500");
            MDC.put("duration", duration + "ms");
            log.error("[ERROR]", e);
            throw e;

        } finally {
            // AOP에서 넣은 것만 제거 (traceId는 MDCFilter가 관리)
            MDC.remove("method");
            MDC.remove("uri");
            MDC.remove("status");
            MDC.remove("duration");
        }
    }
}
