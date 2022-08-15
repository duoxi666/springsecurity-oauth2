package com.imooc.jdbc.entity;

/**
 * @author: Mock
 * @date: 2022/8/15 18:31
 * @Description: UserInfo
 * @Sign 一入码门深似海 头秃自然千金来
 */

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 表示当前类是一个实体类,表示数据库中的一个表
 * 表名默认和类名一样的
 */
@Data
@Entity
public class UserInfo {

    @Id //此注解用于标识主键属性
    @GeneratedValue(strategy = GenerationType.IDENTITY) //设置主键默认生成方式
    private Long id;

    //用户名称
    private String userName;
    //密码
    private String passWord;
    //角色
    private String role;
}
