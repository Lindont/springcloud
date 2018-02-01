package com.aos.cloud.fallback;

import com.aos.cloud.controller.ShoppingFeignClient;
import com.aos.cloud.entity.User;
import org.springframework.stereotype.Component;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-31
 */
@Component
public class ShoppingFeignFallback implements ShoppingFeignClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(0L);
        user.setName("Aosco");
        return user;
    }

    @Override
    public String findTest() {
        return "hahaha";
    }
}
