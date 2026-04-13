package com.msa.filter;

import com.msa.constants.HttpHeaders;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class TraceFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 고유한 Trace ID 생성
        String traceId = UUID.randomUUID().toString()
                .replace("-", "").substring(0, 8);

        // 요청 객체 변조(Mutation)
        ServerHttpRequest request = exchange.getRequest()
                .mutate()
                .header(HttpHeaders.TRACE_ID, traceId)
                .build();

        log.info("[GateWay] traceId: {}", traceId);

        return chain.filter(exchange.mutate().request(request).build());
    }
}
