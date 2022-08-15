package com.imooc.user.mapper;

import com.imooc.user.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMapper {

    List<SysRole> selectRoleByUser(Integer id);
}
