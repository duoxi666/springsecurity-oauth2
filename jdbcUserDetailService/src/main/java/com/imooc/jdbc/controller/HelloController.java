package com.imooc.jdbc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Mock
 * @date: 2022/8/15 22:31
 * @Description:
 * @Sign 一入码门深似海 头秃自然千金来
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hell() {
        return "hello jdbcUserDetailsManager";
    }
}
