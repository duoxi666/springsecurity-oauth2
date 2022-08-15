package com.imooc.jdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

/**
 * @author: Mock
 * @date: 2022/8/15 22:25
 * @Description:
 * @Sign 一入码门深似海 头秃自然千金来
 */
@Configuration
public class ApplicationConfig {

    //通过Spring容器注入DataSource
    @Autowired
    private DataSource dataSource;


    //创建PasswordEncoder对象
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        //不会对密码进行加密，生产环境不推荐
        return NoOpPasswordEncoder.getInstance();
    }


    //创建JdbcUserDetailsService对象
    @Bean("jdbcUserDetailsService")
    public UserDetailsService jdbcUserDetailsService() {

        System.out.println("===dataSource===" + dataSource);

        PasswordEncoder encoder = encoder();

        //初始化加载数据源DataSource(第一次加载的时候,会自动像数据库中插入数据) -- JdbcTemplate对象
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);

        //如果数据库中已经存在账号不添加
        if (!manager.userExists("admin")) {
            manager.createUser(User.withUsername("admin").password(encoder.encode("admin"))
                    .roles("ADMIN", "USER", "MANAGER").build());
        }

        if (!manager.userExists("zs")) {
            manager.createUser(User.withUsername("zs")
                    .password(encoder.encode("123")).roles("USER")
                    .build());
        }

        if (!manager.userExists("ls")) {
            manager.createUser(User.withUsername("ls")
                    .password(encoder.encode("456")).roles("USER", "NORMAL")
                    .build());

        }

        return manager;
    }


}