//package kopo.poly.apigateway.handler;
//
//import org.springframework.beans.factory.BeanNameAware;
//import org.springframework.context.support.ApplicationObjectSupport;
//import org.springframework.core.Ordered;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.CorsUtils;
//import org.springframework.web.reactive.HandlerMapping;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.WebHandler;
//import reactor.core.publisher.Mono;
//
//public abstract class AbstractHandlerMapping extends ApplicationObjectSupport
//        implements HandlerMapping, Ordered, BeanNameAware {
//
//    private static final WebHandler NO_OP_HANDLER = exchange -> Mono.empty();
//
//    @Override
//    public Mono<Object> getHandler(ServerWebExchange exchange) {
//        return getHandlerInternal(exchange).map(handler -> {
//            if (logger.isDebugEnabled()) {
//                logger.debug(exchange.getLogPrefix() + "Mapped to " + handler);
//            }
//            ServerHttpRequest request = exchange.getRequest();
//            if (hasCorsConfigurationSource(handler) || CorsUtils.isPreFlightRequest(request)) {
//                CorsConfiguration config = (this.corsConfigurationSource != null ?
//                        this.corsConfigurationSource.getCorsConfiguration(exchange) : null);
//                CorsConfiguration handlerConfig = getCorsConfiguration(handler, exchange);
//                config = (config != null ? config.combine(handlerConfig) : handlerConfig);
//                if (config != null) {
//                    config.validateAllowCredentials();
//                }
//                if (!this.corsProcessor.process(config, exchange) || CorsUtils.isPreFlightRequest(request)) {
//                    return NO_OP_HANDLER;
//                }
//            }
//            return handler;
//        });
//    }
//
//}