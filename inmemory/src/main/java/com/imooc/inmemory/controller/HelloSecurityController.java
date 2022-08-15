package com.imooc.inmemory.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Mock
 * @date: 2022/8/15 16:20
 * @Description: HelloSecurityController
 * @Sign 一入码门深似海 头秃自然千金来
 */
@RestController
@RequestMapping("/hello")
public class HelloSecurityController {

    @RequestMapping("/world")
    public String sayHello() {
        return "使用内存中的用户信息";
    }

}