package com.demo.springcloud.consumer.ribbon.controller;

import com.demo.springcloud.consumer.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhigang.huang on 2018/2/2.
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/consumer")
    public String consumer(@RequestParam String name) {
        System.out.println("----------hello----" + name);
        return helloService.hiService(name);
    }

}
