package com.imooc.jdbc.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Mock
 * @date: 2022/8/15 18:46
 * @Description: HelloController
 * @Sign 一入码门深似海 头秃自然千金来
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    @PreAuthorize(value = "hasAnyRole({'admin', 'user'})")
    public String sayHello() {
        return "使用内存中的用户信息";
    }

    //指定admin角色的访问方法
    @RequestMapping("/helloAdmin")
    @PreAuthorize("hasAnyRole('admin')")
    public String helloAdmin() {
        return "Hello Admin角色的用户可以访问";
    }

}
