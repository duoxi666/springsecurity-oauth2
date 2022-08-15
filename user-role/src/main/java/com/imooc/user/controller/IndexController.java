package com.imooc.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: Mock
 * @date: 2022/8/15 23:06
 * @Description:
 * @Sign 一入码门深似海 头秃自然千金来
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String toIndexHtml() {
        return "forward:/index.html";
    }
}

