package com.aos.cloud.controller;

import com.aos.cloud.entity.User;
import com.aos.config.FeignConfiguration;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-28
 */


/**
 * 1. 如果指定了configuration 属性, 则需使用 @RequestLine("GET /movie/{id}")
 * 2. 如果没有指定configuration 属性, 则使用@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
 */

@FeignClient(name = "aos-micoo-web", configuration = FeignConfiguration.class)
public interface UserFeignClient {
    @RequestLine("GET /movie/{id}")
    User findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    User postUser(@RequestBody User user);
}
