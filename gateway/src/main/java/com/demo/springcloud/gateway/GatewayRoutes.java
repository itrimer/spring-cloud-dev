package com.demo.springcloud.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutes {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/java/**")
                        .filters( f -> f.stripPrefix(1)
                               .addRequestHeader("h", "t")
                               .addRequestParameter("hello", "v")
                        )
                        .uri("http://localhost:1302/consumer")
                )
                .route(r -> r.path("/api-a/**")
                                .filters(f -> f.stripPrefix(1)
//                                .filter(new TestGetWayFilter())
                                        .addResponseHeader("X-Response-Default-Foo", "ribbon"))
                                .uri("lb://EURAKA-CONSUMER-RIBBON")
                                .order(0)
                                .id("service-route")
                )
                .route(r -> r.path("/api-b/**")
                                .filters(f -> f.stripPrefix(1)
//                                .filter(new TestGetWayFilter())
                                        .addResponseHeader("X-Response-Default-Foo", "feign"))
                                .uri("lb://EUREKA-CONSUMER-FEIGN")
                                .order(0)
                                .id("service-route")
                )
                .build();
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/activity/**")
                                .filters(f -> f.stripPrefix(1)
//                                .filter(new TestGetWayFilter())
                                        .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                                .uri("lb://activity")
                                .order(0)
                                .id("activity-route")
                )
                .build();
    }
}
