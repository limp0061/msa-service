package com.msa.common.filters;

import com.msa.constants.HttpHeaders;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class MDCFilter extends OncePerRequestFilter {
    private static final String MDC_TRACE_KEY = "traceId";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String traceId = request.getHeader(HttpHeaders.TRACE_ID);
        try {
            if (StringUtils.hasText(traceId)) {
                MDC.put(MDC_TRACE_KEY, traceId);
            }
            // TODO: 추후 UserId 추출(Sprint Security - JWT)

            filterChain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }
}
