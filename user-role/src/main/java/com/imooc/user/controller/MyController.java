package com.imooc.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Mock
 * @date: 2022/8/15 23:06
 * @Description:
 * @Sign 一入码门深似海 头秃自然千金来
 */
@RestController
public class MyController {

    @GetMapping(value = "/access/zs", produces = "text/html;charset=utf-8")
    public String sayUser() {
        return "zs 是user 角色";
    }

    @GetMapping(value = "/access/lisi")
    public String sayRead() {
        return "lisi 是 read角色";
    }

    @GetMapping (value = "/access/admin", produces = "text/html;charset=utf-8")
    public String sayAdmin() {
        return "admin 是user, admin角色";
    }
}
