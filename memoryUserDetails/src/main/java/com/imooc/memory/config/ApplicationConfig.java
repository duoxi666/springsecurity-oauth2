package com.imooc.memory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author: Mock
 * @date: 2022/8/15 22:14
 * @Description: ApplicationConfig
 * @Sign 一入码门深似海 头秃自然千金来
 */
@Configuration
public class ApplicationConfig {

    //创建PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        //推荐使用的密码加密类
        return new BCryptPasswordEncoder();
    }


    //创建UserDetailsService的实现类
    @Bean
    public UserDetailsService userDetailsService() {

        PasswordEncoder encoder = passwordEncoder();

        //创建内存的UserDetailsService的实现类对象
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        //创建用户
        manager.createUser(User.withUsername("admin")
                .password(encoder.encode("admin"))
                .roles("ADMIN", "USER").build());
        manager.createUser(User.withUsername("zs")
                .password(encoder.encode("123"))
                .roles("USER").build());

        //更多用户的创建
        return manager;

    }

}