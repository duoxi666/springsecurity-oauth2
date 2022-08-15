package com.imooc.user.service;

/**
 * @author: Mock
 * @date: 2022/8/15 23:05
 * @Description:
 * @Sign 一入码门深似海 头秃自然千金来
 */

import com.imooc.user.entity.SysRole;
import com.imooc.user.entity.SysUser;
import com.imooc.user.mapper.SysRoleMapper;
import com.imooc.user.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * UserDetailsService接口用来加载用户信息。
 *      UserDetailsService接口里面只有一个方法,作用就是通过username查询用户信息。
 *
 * 获取到用户信息后,注入到哪里去呢?
 *      那肯定是注入到认证处理类中的,框架利用AuthenticationManager(接口)来进行认证。
 *      总结:UserDetailService只单纯地负责存取用户信息,除了给框架内的其他组件提供数据外没有其他功能。
 *      而认证过程由AuthenticationManager来完成的。
 */
@Service
public class JdbcUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysRoleMapper roleMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //1.根据username 获取SysUser
        SysUser sysUser = userMapper.selectSysUser(username);

        List<GrantedAuthority> authoritiesList = new ArrayList<>();
        if (null != sysUser) {
            //2.根据userid,获取role
            List<SysRole> roleList = roleMapper.selectRoleByUser(sysUser.getId());
            String roleName = "";
            for (SysRole role : roleList) {
                roleName = role.getName();
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + roleName);
                authoritiesList.add(authority);
            }
            sysUser.setGrantedAuthorityList(authoritiesList);
            return sysUser;
        }

        return null;
    }
}

