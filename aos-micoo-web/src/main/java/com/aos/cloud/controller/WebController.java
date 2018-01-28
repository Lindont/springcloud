package com.aos.cloud.controller;

import com.aos.cloud.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-27
 */
@RestController
public class WebController {
    @RequestMapping("/movie/{id}")
    public User getMovieInfo(@PathVariable int id) {
        System.out.println("111");
        User user = new User();
        user.setId(1L);
        user.setUsername("Lindont");

        if (id == 1) {
            user.setName("id-1");
        } else {
            user.setName("id-2");
        }
        return user;
    }

    @PostMapping("/user")
    public User postUser(@RequestBody User user) {
        return user;
    }
}
