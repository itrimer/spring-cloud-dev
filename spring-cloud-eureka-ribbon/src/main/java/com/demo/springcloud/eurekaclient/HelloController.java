package com.demo.springcloud.eurekaclient;

import com.demo.springcloud.eurekaclient.service.HelloService;
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

    @GetMapping("/hello")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }

}
