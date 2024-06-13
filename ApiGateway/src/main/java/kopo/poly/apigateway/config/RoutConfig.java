package kopo.poly.apigateway.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@RequiredArgsConstructor
@Configuration
public class RoutConfig {

    // 게이트웨이로 접근되는 모든 요청에 대해 URL 분리하기
    @Bean
    public RouteLocator getewayRoutes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(r -> r.path("/search/**").uri("lb://SEARCH-SERVICE:11000")           // 검색엔진 연결될 서버 주소
                ).route(r -> r.path("/mem/**").uri("lb://MEMORIZATIONBOOK-SERVICE:12000")   // 암기장 연결될 서버 주소
                ).route(r -> r.path("/note/**").uri("lb://NOTEBOOK-SERVICE:13000")          // 노트북 연결될 서버 주소
                ).route(r -> r.path("/ss/**").uri("lb://USER-SERVICE:15000")                // 스프링 시큐리티 로그인, 로그아웃
                ).route(r -> r.path("/join/v1/**").uri("lb://USER-SERVICE:15000")           // 회원가입
                ).route(r -> r.path("/user/v1/**").uri("lb://USER-SERVICE:15000")           // 유저 관련 연결될 서버 주소
                ).route(r -> r.path("/mail/**").uri("lb://USER-SERVICE:15000")
                ).build();
    }


}
