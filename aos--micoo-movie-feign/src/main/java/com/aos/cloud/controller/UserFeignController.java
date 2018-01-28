package com.aos.cloud.controller;

import com.aos.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }

    @PostMapping("/test")
    public String postUser(){
        return userFeignClient.postUser();
    }
}
