package com.imooc.inmemory.role.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Mock
 * @date: 2022/8/15 16:35
 * @Description: controller
 * @Sign 一入码门深似海 头秃自然千金来
 */
@RestController
@RequestMapping("/hello")
public class HelloSecurityController {

    @RequestMapping("/world")
    public String sayHello() {
        return "使用内存中的用户信息";
    }


    //指定normal和admin角色都可以访问的方法
    @RequestMapping("/helloUser")
    @PreAuthorize(value = "hasAnyRole('admin', 'user')")
    public String helloUser() {
        return "Hello user,admin角色的用户";
    }

    //制定admin角色的访问方法
    @RequestMapping("/helloAdmin")
    @PreAuthorize(value = "hasAnyRole('admin')")
    public String helloAdmin() {
        return "Hello Admin角色的用户可以访问";
    }

    //制定normal角色的访问方法
    @RequestMapping("/helloNormal")
    @PreAuthorize(value = "hasAnyRole('user')")
    public String hellNormal() {
        return "Hello user角色的用户可以访问";
    }
}
