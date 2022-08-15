package com.imooc.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Mock
 * @date: 2022/8/15 15:01
 * @Description: 启动类
 * @Sign 一入码门深似海 头秃自然千金来
 */
//排除Security的配置,让它不启用,这里排除后,就不会有security的验证功能了
@SpringBootApplication
public class FirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstApplication.class, args);
    }

}