package com.demo.springcloud.client.eureka.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhigang.huang on 2018/2/2.
 */
@RestController
public class HiController {
    private final Logger logger = Logger.getLogger(getClass());

    @Value("${server.port}")
    String port;
    @Value("${spring.application.name}")
    String applicationName;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name) {
        logger.info("/hi, " + name + ".port:" + port + ", service_id:" + applicationName);

        return "hi " + name + ", i am from port:" + port;
    }
}
