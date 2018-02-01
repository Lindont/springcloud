package com.aos.cloud.fallback;

import com.aos.cloud.controller.ShoppingFeignClient;
import com.aos.cloud.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-02-01
 */
@Component
public class UserFeignFallbackFactory implements FallbackFactory<ShoppingFeignClient> {
    private static final Logger logger = LoggerFactory.getLogger(UserFeignFallbackFactory.class);

    @Override
    public ShoppingFeignClient create(Throwable cause) {
        logger.info("================================================");
        logger.info("FallBack; reason was: " + cause.getMessage());
        logger.info("================================================");
        return new ShoppingFeignClientFactory() {
            @Override
            public User findById(Long id) {
                User user = new User();
                user.setId(-1L);
                user.setName("error");
                return user;
            }

            @Override
            public String findTest() {
                return "hahehe";
            }
        };
    }
}
