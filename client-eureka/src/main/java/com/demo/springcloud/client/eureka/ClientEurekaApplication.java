package com.demo.springcloud.client.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by zhigang.huang on 2017/12/4.
 */
@EnableEurekaClient
@SpringBootApplication
public class ClientEurekaApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ClientEurekaApplication.class)
                .web(true).run(args);
    }
}