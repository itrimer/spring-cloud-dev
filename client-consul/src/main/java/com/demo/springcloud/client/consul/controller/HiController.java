package com.demo.springcloud.client.consul.controller;

import com.demo.springcloud.client.consul.Lock;
import com.ecwid.consul.v1.ConsulClient;
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
        Lock lock = new Lock(new ConsulClient(), name, "hi");
        try {
            if (!lock.lock(false)) {
                return "系统繁忙，请稍等！";
            }
            logger.info("/hi, " + name + ".port:" + port + ", service_id:" + applicationName);

            return "hi " + name + ", i am from port:" + port;
        } finally {
            lock.unlock();
        }
    }

}
