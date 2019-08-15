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
                .route(r ->
                        r.path("/java/**")
                                .filters(
                                        f -> f.stripPrefix(1)
//                                                .addRequestHeader("h", "t")
//                                                .addRequestParameter("hello", "v")
                                )
                                .uri("http://localhost:1302/consumer")
                )
                .build();
    }
}
