package com.imooc.user.mapper;

import com.imooc.user.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper {

    int insertSysUser(SysUser user);

    //根据账号名称,获取用户信息
    SysUser selectSysUser(String username);
}
