package com.aos.cloud.feign;

import com.aos.cloud.entity.User;
import com.aos.cloud.fallback.UserFeignFallbackFactory;
import com.aos.config.FeignConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-28
 */


/**
 * 1. 如果指定了configuration 属性, 则需使用 @RequestLine("GET /movie/{id}"), 同时参数要用 @Param 注解
 * 2. 如果没有指定configuration 属性, 则使用 @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET),
 *    不能使用 @GetMapping, 如果使用 @PathVariable 需要指定 value
 * 3. fallbackFactory 是 fallback 的增强版, 不可同时使用
 */
@Component
@FeignClient(name = "aos-micoo-web", configuration = FeignConfiguration.class, fallbackFactory = UserFeignFallbackFactory.class)
public interface ShoppingFeignClient {

    @RequestLine("GET /movie/{id}")
    User findSimpleById(@Param("id") Long id);

    @RequestLine("POST /test")
    String findTest();
}
