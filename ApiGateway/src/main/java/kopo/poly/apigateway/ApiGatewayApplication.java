package kopo.poly.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@EnableWebFluxSecurity
@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

//    @Configuration
//    public class WebConfig implements WebFluxConfigurer {
//        @Override
//        public void addCorsMappings(CorsRegistry registry) {
//            registry.addMapping("/**")
//                    .allowedOrigins("http://192.168.0.21:16000")  // 허용할 출처 : 특정 도메인만 게이트웨이에 접근 가능
//                    .allowedMethods("GET", "POST") // 허용할 HTTP Method
//                    .allowCredentials(true);  // 쿠키에 저장된 인증 정보가 같이 넘어오는 요청 허용
//        }
//    }

}
