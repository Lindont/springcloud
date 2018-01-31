package com.aos.cloud.controller;

import com.aos.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-27
 */
@RestController
public class UserFeignController {

    @Autowired
    private UserFeignClient userFeignClient;


    @GetMapping("/movie/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallBack")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }

    public User findByIdFallBack(Long id) {
        User user = new User();
        user.setId(1L);
        user.setName("ooo");
        return user;
    }


    @PostMapping("/test")
    public String postUser(){
        return userFeignClient.postUser();
    }
}
