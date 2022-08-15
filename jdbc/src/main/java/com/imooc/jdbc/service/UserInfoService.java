package com.imooc.jdbc.service;


import com.imooc.jdbc.entity.UserInfo;

public interface UserInfoService {

    UserInfo findUserInfo(String username);

}
