package com.demo.springcloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhigang.huang on 2018/2/7.
 */
@RestController
public class HelloController {

    @Value("${info.profile}")
    String profile;
    @Value("${file.server.host}")
    String fileServerHost;

    @RequestMapping(value = "/hello")
    public String hi() {
        return "profile is " + profile + ", And file.server.host is " + fileServerHost;
    }
}
