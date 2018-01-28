package com.aos.cloud.controller;

import com.aos.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-27
 */
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("aos-micoo-web");
        System.out.println("===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "===");
        return this.restTemplate.getForObject("http://aos-micoo-web/movie/" + id, User.class);
    }
}
