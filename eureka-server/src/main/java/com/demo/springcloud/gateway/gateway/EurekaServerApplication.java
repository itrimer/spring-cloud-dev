package com.demo.springcloud.gateway.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by zhigang.huang on 2017/12/4.
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaServerApplication.class)
                .web(true).run(args);
    }
}
