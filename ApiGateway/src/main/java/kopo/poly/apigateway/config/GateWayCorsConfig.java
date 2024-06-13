package kopo.poly.apigateway.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

/**
 * 요청 및 응답 헤더 확인을 위한 필터 : 모든 요청과 응답을 가로채고, 헤더 로깅
 */
@Configuration
public class GateWayCorsConfig {

    @Bean
    @Order(1) // 필터의 실행 순서 지정(숫자가 낮을수록 높은 우선순위)
    public GlobalFilter logRequestFilter() {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            request.getHeaders().forEach((key, value) -> {
                System.out.println("요청 헤더 : " + key + " = " + value);
            });

            return chain.filter(exchange);
        };
    }

    @Bean
    @Order(2)
    public GlobalFilter logResponseFilter() {
        return (exchange, chain) -> chain.filter(exchange).then(Mono.fromRunnable(() -> {
            ServerHttpResponse response = exchange.getResponse();
            response.getHeaders().forEach((key, value) -> {
                System.out.println("응답 헤더 : " + key + " = " + value);
            });
        }));
    }


}

/**
 * 발생한 에러
 * <p>
 * error: incompatible types: org.springframework.http.server.reactive.ServerHttpRequest cannot be converted to org.springframework.http.server.ServerHttpRequest
 *             ServerHttpRequest request = exchange.getRequest();
 * <p>
 * 이유 : exchange.getRequest()는 org.springframework.http.server.reactive.ServerHttpRequest 인데, 코드에서는 org.springframework.http.server.ServerHttpRequest 타입으로 선언하고 있어서 타입 불일치 오류가 발생함
 * <p>
 * 해결 : import문 수정
 */
