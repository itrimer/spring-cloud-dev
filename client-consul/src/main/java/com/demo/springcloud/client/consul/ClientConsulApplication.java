package com.demo.springcloud.client.consul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by zhigang.huang on 2017/12/4.
 */
@SpringBootApplication
public class ClientConsulApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ClientConsulApplication.class)
                .web(true).run(args);
    }
}
