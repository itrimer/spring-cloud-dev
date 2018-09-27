package com.demo.springcloud.consumer.ribbon.controller;

import com.demo.springcloud.consumer.ribbon.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zhigang.huang on 2018/2/2.
 */
@RestController
public class HelloController {

    @Resource
    HelloService helloService;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        System.out.println("----------hello----" + name);
        return helloService.sayHiFromClientOne(name);
    }

}
