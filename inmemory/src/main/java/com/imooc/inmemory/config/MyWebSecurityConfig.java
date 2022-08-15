package com.imooc.inmemory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: Mock
 * @date: 2022/8/15 16:20
 * @Description: config
 * @Sign 一入码门深似海 头秃自然千金来
 */
@Configuration //表示当前类是一个配置类(相当于spring的xml配置文件),在这个类中,方法的返回值是java对象,这些对象是放入到spring容器中的
@EnableWebSecurity //表示启用spring security安全框架的功能。
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    //在此方法中配置用户和密码的信息,作为登录的数据
    //java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
    //spring security5以后,要求密码必须加密,否则报以上错。
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = passwordEncoder();

        //适用于系统用户不多的情况下
        // 设置用户名和密码, 以及角色
        auth.inMemoryAuthentication().withUser("zhangsan")
                .password(passwordEncoder.encode("123456"))
                .roles();
        auth.inMemoryAuthentication().withUser("lisi")
                .password(passwordEncoder.encode("lisi"))
                .roles();
        auth.inMemoryAuthentication().withUser("admin")
                .password(passwordEncoder.encode("admin"))
                .roles();
    }


    //创建密码的加密
    @Bean
    public PasswordEncoder passwordEncoder() {
        //创建PasswordEncoder的实现了
        return new BCryptPasswordEncoder();
    }

}