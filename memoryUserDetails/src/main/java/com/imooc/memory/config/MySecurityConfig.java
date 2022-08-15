package com.imooc.memory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author: Mock
 * @date: 2022/8/15 22:14
 * @Description:
 * @Sign 一入码门深似海 头秃自然千金来
 */
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService = null;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.userDetailsService(userDetailsService);
    }
}
