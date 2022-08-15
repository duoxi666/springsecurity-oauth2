package com.imooc.user.entity;

/**
 * @author: Mock
 * @date: 2022/8/15 22:51
 * @Description:
 * @Sign 一入码门深似海 头秃自然千金来
 */

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * UserDetails是Spring Security基础接口,包含某个用户的账号,密码,权限,状态(是否锁定)等信息。
 * 只有getter方法。相当于一个规范,作用主要是用来和数据库做交互用的。简单来说,就是用户名传过来，
 * 这个类负责效验用户名是否存在业务逻辑。Security这个框架不管你的应用时怎么存储用户和权限信息的。
 * 只要你取出来的时候把它包装成一个UserDetails对象给我用就可以了。
 *
 * 怎么用：只需要在包含用户信息实体类上实现这个接口，并重写里面的方法
 *
 *
 * UserDetails用来做什么? 为什么还要带上权限集合?
 *      把这些信息取出来,然后包装成一个对象交由框架去认证。
 *      登录成功后也不是什么都能访问的,还要根据你所拥有的权限进行判断。有权限你才能访问特定的对象。
 *      Security框架是这样设计的,即认证成功后,就把用户信息和拥有的权限都存储在SecurityContext中,
 *      当访问受保护资源(某个对象/方法)的时候,就把权限拿出来比对,看看是否满足。
 *
 * 什么时候提供UserDetails信息,怎么提供?
 *      那肯定是在认证的时候,其实认证的操作,框架都已经帮你实现了,它所需要的只是,你给我提供获取信息的方式。
 *      所以它就定义一个接口,然后让你去实现,实现好了之后再注入给它。
 *      框架提供一个UserDetailsService接口用来加载用户信息。
 *          UserDetailsService里面只有一个方法,作用就说通过username查询用户的信息。
 *
 */
@Data
public class SysUser implements UserDetails {

    private Integer id;

    private String username;

    private String password;

    private String realname;


    private boolean isExpired;

    private boolean isLocked;

    private boolean isCredentials;

    private boolean isEnabled;

    private Date createTime;

    private Date loginTime;

    private List<GrantedAuthority> grantedAuthorityList;

    public SysUser() {

    }

    public SysUser(String username, String password, String realname, boolean isExpired, boolean isLocked, boolean isCredentials, boolean isEnabled, Date createTime, Date loginTime, List<GrantedAuthority> grantedAuthorityList) {
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.isExpired = isExpired;
        this.isLocked = isLocked;
        this.isCredentials = isCredentials;
        this.isEnabled = isEnabled;
        this.createTime = createTime;
        this.loginTime = loginTime;
        this.grantedAuthorityList = grantedAuthorityList;
    }

    //权限列表集合
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorityList;
    }

    //获取密码
    @Override
    public String getPassword() {
        return password;
    }

    //获取用户名
    @Override
    public String getUsername() {
        return username;
    }

    //账号是否过期
    @Override
    public boolean isAccountNonExpired() {
        return isExpired;
    }

    //账号是否锁定
    @Override
    public boolean isAccountNonLocked() {
        return isLocked;
    }

    //凭证是否过期
    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentials;
    }

    //账号是否启用
    @Override
    public boolean isEnabled() {
        return isEnabled;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public List<GrantedAuthority> getGrantedAuthorityList() {
        return grantedAuthorityList;
    }


    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", isExpired=" + isExpired +
                ", isLocked=" + isLocked +
                ", isCredentials=" + isCredentials +
                ", isEnabled=" + isEnabled +
                ", createTime=" + createTime +
                ", loginTime=" + loginTime +
                ", grantedAuthorityList=" + grantedAuthorityList +
                '}';
    }
}
