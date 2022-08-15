package com.imooc.memory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Mock
 * @date: 2022/8/15 22:15
 * @Description:
 * @Sign 一入码门深似海 头秃自然千金来
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello Security";
    }

}
