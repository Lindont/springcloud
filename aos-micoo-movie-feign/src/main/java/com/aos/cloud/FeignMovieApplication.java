package com.aos.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-26
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignMovieApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignMovieApplication.class, args);
    }
}
