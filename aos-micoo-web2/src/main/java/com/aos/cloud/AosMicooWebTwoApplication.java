package com.aos.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-26
 */
@SpringBootApplication
@EnableEurekaClient
public class AosMicooWebTwoApplication {
    public static void main(String[] args) {
        SpringApplication.run(AosMicooWebTwoApplication.class, args);
    }
}
