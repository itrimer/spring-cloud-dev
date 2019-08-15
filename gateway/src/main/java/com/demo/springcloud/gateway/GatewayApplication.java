package com.demo.springcloud.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by zhigang.huang on 2017/12/4.
 */
@SpringBootApplication
//@EnableConfigurationProperties(UriConfiguration.class)
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}

