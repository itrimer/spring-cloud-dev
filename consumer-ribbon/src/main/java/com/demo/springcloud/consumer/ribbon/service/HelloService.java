package com.demo.springcloud.consumer.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * Created by zhigang.huang on 2018/2/5.
 */
@Service
public class HelloService {
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        System.out.println("hiService--" + (new Date()));
        ServiceInstance serviceInstance = loadBalancerClient.choose("client-eureka");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hi?name=" + name;
        System.out.println(url);

        return restTemplate.getForObject(url, String.class);
    }

    public String sayHiService(String name) {
        return restTemplate.getForObject("http://CLIENT-EUREKA/hi?name=" + name, String.class);
    }
}