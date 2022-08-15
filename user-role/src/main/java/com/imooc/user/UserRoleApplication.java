package com.imooc.user;

import com.imooc.user.entity.SysUser;
import com.imooc.user.mapper.SysUserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: Mock
 * @date: 2022/8/15 22:49
 * @Description:
 * @Sign 一入码门深似海 头秃自然千金来
 */
@MapperScan(value = "com.imooc.user.mapper")
@SpringBootApplication
public class UserRoleApplication {

    @Autowired
    SysUserMapper sysUserMapper;

    public static void main(String[] args) {
        SpringApplication.run(UserRoleApplication.class, args);
    }

    /**
     * 添加管理员角色的用户
     */
//    @PostConstruct
    public void jdbcInit() {

        List<GrantedAuthority> list = new ArrayList<>();

        //参数角色名称, 需要以“ROLE_”开头,后面加上自定义的角色名称
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + "ADMIN");

        list.add(authority);

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Date date = new Date();
        SysUser sysUser2 = new SysUser(
                "admin", encoder.encode("admin"), "管理员", true, true, true, true, date, date, list
        );

        sysUserMapper.insertSysUser(sysUser2);
    }

    /**
     * 添加User角色的用户
     */
//    @PostConstruct
    public void jdbcInitUser() {

        List<GrantedAuthority> list = new ArrayList<>();

        //参数角色名称, 需要以“ROLE_”开头,后面加上自定义的角色名称
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + "USER");

        list.add(authority);

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        Date date = new Date();


        SysUser sysUser2 = new SysUser(
                "zs", encoder.encode("123"), "张三", true, true, true, true, date, date, list
        );

        sysUserMapper.insertSysUser(sysUser2);
    }

    /**
     * 添加READ角色的用户
     */
//    @PostConstruct
    public void jdbcInitREAD() {

        List<GrantedAuthority> list = new ArrayList<>();

        //参数角色名称, 需要以“ROLE_”开头,后面加上自定义的角色名称
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + "READ");

        list.add(authority);

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        Date date = new Date();


        SysUser sysUser2 = new SysUser(
                "lisi", encoder.encode("456"), "李四", true, true, true, true, date, date, list
        );

        sysUserMapper.insertSysUser(sysUser2);
    }

}
