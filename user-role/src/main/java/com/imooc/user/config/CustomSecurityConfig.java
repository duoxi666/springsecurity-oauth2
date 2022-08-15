package com.imooc.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author: Mock
 * @date: 2022/8/15 23:06
 * @Description:
 * @Sign 一入码门深似海 头秃自然千金来
 */
@Configuration
@EnableWebSecurity //表示启用spring security安全框架的功能。
//@EnableGlobalMethodSecurity(prePostEnabled = true)  //启用方法级别的认证 prePostEnabled: boolean默认是false
// true:表示可以使用@PreAuthoriz注解和@PostAuthorize注解
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 认证过程由AuthenticationManager来完成的。
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth); //这个都必须注释掉
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //        super.configure(http); //这个一定要去掉
        System.out.println("=====configure HttpSecurity========");
        http.authorizeRequests()
                //指定那些地址可以直接访问,和登录有关的需要进行指定
                .antMatchers("/index", "/mylogin.html", "/login", "/error.html").permitAll()
                .antMatchers("/access/zs/**").hasRole("USER") //配置角色
                .antMatchers("/access/lisi/**").hasRole("READ")
                .antMatchers("/access/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
//                .usernameParameter("myname")        //设置自定义的登录参数
//                .passwordParameter("mypwd")
                .loginPage("/mylogin.html") //指定自定义登录页面
                .loginProcessingUrl("/login") //指定登录访问的地址
                .failureUrl("/error.html") //当出现错误,比如用户名密码出现错误,这里可以配置访问。
                .and()
                //关于跨域访问的安全设置,先禁用
                .csrf().disable(); //关闭csrf,不使用session
    }
}

