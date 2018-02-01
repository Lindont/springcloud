package com.aos.cloud.controller;

import com.aos.cloud.entity.User;
import com.aos.cloud.feign.ShoppingFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-27
 */
@RestController
public class UserFeignController {

    @Autowired
    private ShoppingFeignClient shoppingFeignClient;


    @GetMapping("/simple/{id}")
    public User findSimpleById(@PathVariable Long id) {
        return shoppingFeignClient.findSimpleById(id);
    }

    @PostMapping("/test")
    public String findfTest() {
        return shoppingFeignClient.findTest();
    }
}
