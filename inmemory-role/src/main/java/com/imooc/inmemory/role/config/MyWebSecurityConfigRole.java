package com.imooc.inmemory.role.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: Mock
 * @date: 2022/8/15 16:33
 * @Description: config role
 * @Sign 一入码门深似海 头秃自然千金来
 */
@Configuration //表示当前类是一个配置类(相当于spring的xml配置文件),在这个类中,方法的返回值是java对象,这些对象是放入到spring容器中的
@EnableWebSecurity //表示启用spring security安全框架的功能。
@EnableGlobalMethodSecurity(prePostEnabled = true)  //启用方法级别的认证 prePostEnabled: boolean默认是false
// true:表示可以使用@PreAuthoriz注解和@PostAuthorize注解

/**
 *  @PreAuthorize 注解，顾名思义是进入方法前的权限验证，@PreAuthorize 声明这个方法所需要的权限表达式，
 *      例如：@PreAuthorize("hasAuthority('sys:dept:delete')")，
 *      根据这个注解所需要的权限，再和当前登录的用户角色所拥有的权限对比，
 *      如果用户的角色权限集Set中有这个权限，则放行；没有，拒绝
 *
 * @PostAuthorize注解,表示方法或类执行结束后,再判断权限,此注解很少用到
 *
 */
public class MyWebSecurityConfigRole extends WebSecurityConfigurerAdapter {

    //在此方法中配置用户和密码的信息,作为登录的数据
    //java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
    //spring security5以后,要求密码必须加密,否则报以上错。
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = passwordEncoder();

        //定义两个角色, user,admin
        auth.inMemoryAuthentication().withUser("zhangsan")
                .password(passwordEncoder.encode("123456"))
                .roles("user");
        auth.inMemoryAuthentication().withUser("lisi")
                .password(passwordEncoder.encode("123456"))
                .roles("user");
        auth.inMemoryAuthentication().withUser("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("admin", "user");
    }

    //创建密码的加密
    @Bean
    public PasswordEncoder passwordEncoder() {
        //创建PasswordEncoder的实现了
        return new BCryptPasswordEncoder();
    }
}
