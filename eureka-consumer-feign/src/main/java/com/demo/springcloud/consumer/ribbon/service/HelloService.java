package com.demo.springcloud.consumer.ribbon.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zhigang.huang on 2018/2/5.
 */
@FeignClient(value = "EUREKA-CLIENT", fallback = HelloServiceHystric.class)
public interface HelloService {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}