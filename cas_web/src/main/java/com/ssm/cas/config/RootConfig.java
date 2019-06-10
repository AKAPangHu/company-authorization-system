package com.ssm.cas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author: 胖虎
 * @date: 2019/6/10 8:31
 **/
@Configuration
@ComponentScan(basePackages = {"com.ssm.cas.service.impl", "com.ssm.cas.utils"})
public class RootConfig {
    @Bean(name = "bCryptPasswordEncoder")
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
