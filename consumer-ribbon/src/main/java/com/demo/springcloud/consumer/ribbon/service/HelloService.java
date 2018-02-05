package com.demo.springcloud.consumer.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hi?name=" + name;
        System.out.println(url);

        return restTemplate.getForObject(url, String.class);
    }

    public String sayHiService(String name) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hi?name=" + name, String.class);
    }
}