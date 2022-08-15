package com.imooc.jdbc.provider;

import com.imooc.jdbc.dao.UserInfoDao;
import com.imooc.jdbc.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mock
 * @date: 2022/8/15 18:41
 * @Description: MyUserDetailService
 * @Sign 一入码门深似海 头秃自然千金来
 */
@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserInfoDao dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = null;

        User user = null;

        if (username != null) {
            userInfo = dao.findByUserName(username);
            if(null != userInfo) {
                userInfo = dao.findByUserName(username);
                //创建List集合
                List<GrantedAuthority> list = new ArrayList<>();

                //角色必须以ROLE_开头
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + userInfo.getRole());
                list.add(authority);
                //创建User对象
                user = new User(userInfo.getUserName(), userInfo.getPassWord(), list);
            }

        }


        return user;
    }
}
