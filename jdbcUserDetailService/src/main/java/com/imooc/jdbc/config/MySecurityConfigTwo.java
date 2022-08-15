package com.imooc.jdbc.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;

/**
 * @author: Mock
 * @date: 2022/8/15 22:30
 * @Description:
 * @Sign 一入码门深似海 头秃自然千金来
 */
@EnableWebSecurity //表示启用spring security安全框架的功能。
public class MySecurityConfigTwo extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService jdbcUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.userDetailsService(jdbcUserDetailsService);
    }
}
