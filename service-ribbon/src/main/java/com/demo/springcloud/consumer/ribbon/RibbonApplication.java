package com.demo.springcloud.consumer.ribbon;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhigang.huang on 2017/12/4.
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
public class RibbonApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RibbonApplication.class)
                .web(true).run(args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
