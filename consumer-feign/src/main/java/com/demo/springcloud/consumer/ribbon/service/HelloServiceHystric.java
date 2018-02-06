package com.demo.springcloud.consumer.ribbon.service;

import org.springframework.stereotype.Component;

/**
 * Created by zhigang.huang on 2018/2/5.
 */
@Component
public class HelloServiceHystric implements HelloService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}